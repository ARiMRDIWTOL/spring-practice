(function () {
    'use strict';

    var app = angular
        .module('springPractice', [
            'ngRoute',
            'ngAnimate',
            'mgcrea.ngStrap',
            'pascalprecht.translate',
            'ui.bootstrap',
            'home',
            'auth',
            'users'
        ]);

    app.run(['$rootScope', '$location', function($rootScope, $location) {

        $rootScope.getClass = function(pathName) {
            pathName = pathName.replace(new RegExp("/", 'g'), "\\/");

            var regExp = new RegExp("^" + pathName + "(\\/\\d+|\\/create|\\/)?$");

            if(regExp.test($location.path())) {
                return "active";
            } else {
                return "";
            }

        };
    }]);

})();