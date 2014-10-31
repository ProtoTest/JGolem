function getJsonLog() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open("GET", "log.json", false);
  xmlHttp.send(null);
  return xmlHttp.responseText;
}

var reportApp = angular.module('reportApp', []);

function buildTransforms(defaults) {
  var transforms = defaults.slice(0);
  transforms.unshift(function (value) {
    value = value.trim();
    value = value.replace(/}{/g, '},{');
    return value.substr(0, value.length - 1).concat(']')
  });
  return transforms;
}

reportApp.controller('LogLinesCtrl', function ($scope, $http) {
  $scope.logFilter = 'none';
  $scope.setLogFilter = function(testName) {
    $scope.logFilter = testName;
    $scope.$apply();
  };
  $http({
    url: 'log.json',
    method: 'get',
    transformResponse: buildTransforms($http.defaults.transformResponse)

  }).success(function (data) {
    $scope.testNames = [];
    $scope.testLogs = {};
    angular.forEach(data, function(logLine) {
      var isDuplicate = false;
      for (var i = 0; i < $scope.testNames.length; i++) {
        if (angular.equals(logLine.testName, $scope.testNames[i])) {
          isDuplicate = true;
          break;
        }
      }
      if (!isDuplicate) {
        $scope.testNames.push(logLine.testName);
        $scope.testLogs[logLine.testName] = [];
      }
      $scope.testLogs[logLine.testName].push(logLine);
    });
    $scope.lines = data;
  });
});

reportApp.filter('unique', function () {
  return function (items, filterOn) {
    if (filterOn === false) {
      return items;
    }
    if ((filterOn || angular.isUndefined(filterOn)) && angular.isArray(items)) {
      var newItems = [];
//          get = angular.isString(filterOn) ? $parse(filterOn) : function (item) { return item; };
      var extractValueToCompare = function (item) {
        return angular.isObject(item) ? get(item) : item;
      };
      angular.forEach(items, function (item) {
        var isDuplicate = false;
        for (var i = 0; i < newItems.length; i++) {
          if (angular.equals(extractValueToCompare(newItems[i][filterOn]), item[filterOn])) {
            isDuplicate = true;
            break;
          }
        }
        if (!isDuplicate) {
          newItems.push(item);
        }
      });
      items = newItems;
    }
    return items;
  };
});