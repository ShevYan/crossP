'use strict';

/* Directives */

var AppDirectives = angular.module('AngularSpringApp.directives', []);

AppDirectives.directive('appVersion', 'logService', ['version',function(version, logService) {
			logService.log.info('directives.js: ');
			return function(scope, elm, attrs) {
				elm.text(version);
			};
		}
	]);