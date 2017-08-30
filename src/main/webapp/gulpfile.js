var gulp = require('gulp'),
    sass = require('gulp-sass');
gulp.task('sass',function(){
	return gulp.src('scss/*.scss')
	    .pipe(sass())
	    .pipe(gulp.dest('testCss/css'));
});
gulp.task('default',['sass']);