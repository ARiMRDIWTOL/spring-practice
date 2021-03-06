(function () {
    'use strict';

    angular.module('springPractice').config(['$translateProvider',
        function($translateProvider) {
            $translateProvider.fallbackLanguage('pl_PL')
                .useSanitizeValueStrategy('escape')
                .useStaticFilesLoader({
                    prefix: 'assets/i18n/lang-',
                    suffix: '.json'
                })
                .determinePreferredLanguage();
        }
    ]);

})();

