# UnfocusableViewPager2
ViewPager2 1.0.0 with added ability to disable page selection to fix 
[EditText focus bug](https://github.com/android/views-widgets-samples/issues/107)
All you need to do is:
1. Add the url to jitpack.io in your build.gradle(project level)
  ```
  allprojects {
    repositories {
      maven { url 'https://jitpack.io' }
    }
  }
  ```
or if you use kotlin DSL in settings.gradle add:
   ```
   dependencyResolutionManagement {
     repositories {
       maven(url = "https://jitpack.io")
     }
   }
   ```
2. Add `implementation 'com.github.MrRuslanYT:UnfocusableViewPager2:1.0.0'` in your build.gradle(app)
3. Call `viewPager.pageSelectionEnabled = false // default value is true`
