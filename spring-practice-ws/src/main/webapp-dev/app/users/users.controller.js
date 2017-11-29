(function () {
    'use strict';

    angular
        .module('users')
        .controller('UsersController', UsersController);

    UsersController.$inject = ['$http', '$route', '$location'];

    /* @ngInject */
    function UsersController($http, $route, $location) {
        var vm = this;
        vm.users = [];
        vm.deleteUser = deleteUser;
        vm.createUser = createUser;

        ////////////////

        $http.get('/users/').then(function (response) {
            vm.users = response.data;
        });

        function createUser() {
            $location.path('/users/create');
        }

        function deleteUser(id) {
            if (confirm("Czy na pewno chcesz usunąć użytkownika?")) {
                $http.delete('/users/' + id).then(function () {
                    $route.reload();
                });
            }
        }
    }

})();

