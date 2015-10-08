'use strict';

angular.module('bootdemoApp')
    .controller('AuthorDetailController', function ($scope, $rootScope, $stateParams, entity, Author, Book) {
        $scope.author = entity;
        $scope.load = function (id) {
            Author.get({id: id}, function(result) {
                $scope.author = result;
            });
        };
        $rootScope.$on('bootdemoApp:authorUpdate', function(event, result) {
            $scope.author = result;
        });
    });
