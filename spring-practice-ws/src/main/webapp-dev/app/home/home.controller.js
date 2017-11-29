(function () {
    'use strict';

    angular
        .module('home')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$http'];

    /* @ngInject */
    function HomeController($http) {
        var vm = this;
        vm.bodyText = '';

        ////////////////

        $http.get('/test/sayHello').then(function (response) {
            vm.bodyText = response.data;
        });
    }

})();

