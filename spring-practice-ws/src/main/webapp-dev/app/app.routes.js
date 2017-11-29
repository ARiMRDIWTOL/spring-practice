(function () {
    'use strict';

    angular.module('springPractice')
        .config(['$routeProvider', '$httpProvider',
            function ($routeProvider, $httpProvider) {

                $routeProvider.when('/error', {
                    templateUrl: 'app/errorPage.html'
                });

                $routeProvider.when('/', {
                    templateUrl: 'app/home/loginForm.html',
                    controller: 'AuthController',
                    controllerAs: 'authCtrl'
                });

                $routeProvider.when('/home', {
                    templateUrl: 'app/home/home.html',
                    controller: 'HomeController',
                    controllerAs: 'homeCtrl'
                });

                $routeProvider.when('/users', {
                    templateUrl: 'app/users/users.html',
                    controller: 'UsersController',
                    controllerAs: 'usersCtrl'
                });

                $routeProvider.when('/users/list', {
                    templateUrl: 'app/users/usersList.html',
                    controller: 'UsersController',
                    controllerAs: 'usersCtrl'
                });

                $routeProvider.when('/users/create', {
                    templateUrl: 'app/users/userDetails.html',
                    controller: 'UserDetailsController',
                    controllerAs: 'userDetCtrl'
                });

                $routeProvider.when('/users/permissions', {
                    templateUrl: 'app/users/usersPermissions.html',
                    controller: 'UsersController',
                    controllerAs: 'usersCtrl'
                });

                $routeProvider.otherwise({
                    redirectTo: '/error'
                });

                $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
            }
        ]);

})();
