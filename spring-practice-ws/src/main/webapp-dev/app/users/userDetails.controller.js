(function () {
    'use strict';

    angular
        .module('users')
        .controller('UserDetailsController', UserDetailsController);

    UserDetailsController.$inject = ['$http', '$routeParams', '$location'];

    /* @ngInject */
    function UserDetailsController($http, $routeParams, $location) {
        var vm = this;
        vm.user = {};
        vm.roles = [];
        vm.edit = edit;
        vm.backToList = backToList;
        vm.save = save;

        onActive();

        ////////////////

        function onActive() {
            $http.get('/permissions/all').then(function (response) {
                vm.roles = response.data;
            });
            if (edit()) {
                $http.get('/users/' + $routeParams.id).then(function (response) {
                    vm.user = response.data;
                });
            }
        }

        function backToList() {
            $location.path('/users/list');
        }

        function save() {
            if (!edit()) {
                $http.post('/users/', vm.user).then(onSuccess, onFailure);
            } else {
                $http.put('/users/', vm.user).then(onSuccess, onFailure);
            }
        }

        function edit() {
            return $routeParams.id !== undefined && !isNaN($routeParams.id);
        }

        function onSuccess() {
            $location.path("/users");
        }

        function onFailure() {
            alert("Nie udało się zapisać użytkownika. Sprawdź poprawność danych i spróbuj ponownie.");
        }
    }

})();

