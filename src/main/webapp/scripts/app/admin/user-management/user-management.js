'use strict';

angular.module('bootdemoApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('user-management', {
                parent: 'admin',
                url: '/user-management',
                data: {
                    authorities: ['ROLE_ADMIN'],
                    pageTitle: 'bootdemo'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/user-management/user-management.html',
                        controller: 'UserManagementController'
                    }
                },
                resolve: {
                    
                }
            })
            .state('user-management-detail', {
                parent: 'admin',
                url: '/user-management/:login',
                data: {
                    authorities: ['ROLE_ADMIN'],
                    pageTitle: 'bootdemo'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/user-management/user-management-detail.html',
                        controller: 'UserManagementDetailController'
                    }
                },
                resolve: {
                    
                }
            });
    });
