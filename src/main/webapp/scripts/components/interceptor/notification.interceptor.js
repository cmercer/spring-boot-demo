 'use strict';

angular.module('bootdemoApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-bootdemoApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-bootdemoApp-params')});
                }
                return response;
            },
        };
    });