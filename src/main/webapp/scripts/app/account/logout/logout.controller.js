'use strict';

angular.module('bootdemoApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
