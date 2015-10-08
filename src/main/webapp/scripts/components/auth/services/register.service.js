'use strict';

angular.module('bootdemoApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


