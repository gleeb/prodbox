module.exports = function (config) {
    config.set({
        // base path used to resolve all patterns
        basePath: '',

        // frameworks to use
        // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
        frameworks: ['mocha', 'chai-as-promised', 'chai', 'chai-things'],

        // list of files/patterns to load in the browser
        files: ['./node_modules/babel-polyfill/dist/polyfill.min.js',
            './node_modules/phantomjs-polyfill/bind-polyfill.js',
            {pattern: 'spec.bundle.js', watched: false}
        ],

        // files to exclude
        exclude: ['./avatars/*.*'],

        // preprocess matching files before serving them to the browser
        // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
        preprocessors: {'spec.bundle.js': ['webpack', 'sourcemap']},

        webpack: {
            devtool: 'eval-source-map',
            resolve: {
                modulesDirectories: ['node_modules', 'bower_components']
            },
            module: {
                postLoaders: [
                    {
                        test: /\.js$/,
                        exclude: [/app\/lib/, /node_modules/, /bower_components/, /\.spec.js$/, /\.mock.js$/],
                        loader: 'istanbul-instrumenter'
                    }
                ],
                loaders: [
                    {test: /\.js$/, exclude: [/app\/lib/, /node_modules/, /bower_components/], loader: 'babel'},
                    {test: /\.html$/, loader: 'html'},
                    {
                        test: /\.(jpe?g|png|gif|svg)$/i, loaders: ['file']
                    },
                    {test: /\.yml$/, loader: 'json!yaml' },
                    {test: /\.css$/, loader: 'style!css'},
                    {test: /\.scss$/, loader: 'style!css!sass?sourceMap'},
                    {test: /\.(otf|ttf|eot|woff(2)?)(\?[a-z0-9]+)?$/, loader: 'file-loader'}
                ]
            }
        },

        webpackServer: {
            noInfo: true, // prevent console spamming when running in Karma!
            watch:true
        },

        // available reporters: https://npmjs.org/browse/keyword/karma-reporter
        reporters: ['mocha', 'notify', 'coverage'],

        notifyReporter: {
            reportEachFailure: true, // Default: false, Will notify on every failed sepc
            reportSuccess: false // Default: true, Will notify when a suite was successful
        },

        coverageReporter: {
            reporters: [
                {type: 'html', dir: 'coverage/'},
                {type: 'lcov', dir: 'coverage/'},
                {type: 'text-summary'}
            ]
        },

        // web server port
        port: 9876,

        // enable colors in the output
        colors: true,

        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_INFO,

        // toggle whether to watch files and rerun tests upon incurring changes
        autoWatch: true,

        // start these browsers
        // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
        browsers: ['PhantomJS'],

        // if true, Karma runs tests once and exits
        singleRun: false
    });
};
