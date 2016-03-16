var gulp = require('gulp');
var connect = require('gulp-connect');
var webpack = require('webpack-stream');
var browserSync = require('browser-sync');
var proxyMiddleware = require('http-proxy-middleware');

gulp.task('connect', ['copy'], function() {

  var server = {
    baseDir: "./build"
  };

  server.middleware = proxyMiddleware('http://localhost:9000/api');

  browserSync.instance = browserSync.init({
    startPath: './',
    server: server,
    browser: "google chrome"
  });
});

gulp.task('scripts', function() {
	return gulp.src('./src/app.ts')
    .pipe(webpack(require('./webpack.config.js')))
    .pipe(gulp.dest('./build'))
  ;
});

gulp.task('copy', function() {

  return gulp.src(['./src/**/**.*', '!./src/**/**.ts'], {
      base: './src'
    })
    .pipe(gulp.dest('./build'))
  ;
});

gulp.task('build', ['scripts', 'copy']);

gulp.task('default', ['scripts', 'copy', 'connect'], function() {
  gulp.watch(['!./src/**/**.ts', './src/**/**.*'], ['copy', browserSync.reload]);
  gulp.watch('./src/**/**.ts', ['scripts']);
});
