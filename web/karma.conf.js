//jshint strict: false
module.exports = function (config) {
    config.set({

        basePath: './app',

        files: [
            'bower_components/angular/angular.js',
            'bower_components/angular-route/angular-route.js',
            'bower_components/angular-mocks/angular-mocks.js',
            'components/**/*.js',
            'view*/**/*.js',
            'services/**/*.js'
        ],



        // preprocess matching files before serving them to the browser
        // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
        preprocessors: {
            // source files, that you wanna generate coverage for
            // do not include tests or libraries
            // (these files will be instrumented by Istanbul)
            'view*/**/*.js': ['coverage']
        },



        autoWatch: true,

        frameworks: ['jasmine'],

        browsers: ['Chrome'],

        plugins: [
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-jasmine',
            'karma-junit-reporter',
            'karma-coverage'
        ],

       // junitReporter: {
            //outputFile: 'test_out/unit.xml',
       //     suite: 'unit'
       // },
        reporters: ['progress', 'coverage'],
        // optionally, configure the reporter
        coverageReporter: {
            type : 'html',
            dir : 'coverage/'
        }

    });
};
