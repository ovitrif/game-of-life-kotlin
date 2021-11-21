# Android Game Of Life Kata

An Android App that provides a testable solution to the Game Of Life Kata.

## Build & Run

1. Clone the git repository.
1. Make sure you've installed [Android Studio][AndroidStudio].
1. In Android Studio, open the project from the local repository.  
   The project uses the Android Gradle plugin version 7.0.3 which requires JDK11.  
   If you get an error about JDK version, Set JDK location in Android Studio to JDK11.  
   More info on this [Stack Overflow answer][StackOverflowJDK11QA].
1. Go to Tools → AVD Manager and create an emulated device.
1. Run from Android Studio's menu using Run → Run 'app'.

[AndroidStudio]: https://developer.android.com/studio/index.html
[StackOverflowJDK11QA]: https://stackoverflow.com/a/67002271

## Tests
1. There are a unit test for testing the domain logic of the game.
1. To run the tests simply use Android Studio:
    - Make sure you're using the Android view in the project browser tool window.
    - Right click on the `java → com.masivotech.gameoflife.ui.domain` folder, and
    - Click "Run 'Tests in 'com.masivo...'".
