# Imgur Gallery
Loading Imgur Gallery images using clean architecture
<p align="center"><img src="https://cdn.vox-cdn.com/thumbor/OZIH26mVpds7wpxLZP_fi7t6gHs=/0x50:969x595/1600x900/cdn.vox-cdn.com/uploads/chorus_image/image/46063600/imgur.0.0.png" ></a></p>

## Prereqs

- Android Studio 4.0.1
- SDK 21+

## Features

A simple app that allows browsing Imgur gallery using https://apidocs.imgur.com/. Filter button is used for populating top, viral, hot etc images.

## Overall Architecture 

App is based on **MVVM** architecture. Structure is broken down by the general purpose of contained source files. Below are the dependencies used in the project

1. **Clean Architecture** : Used for structuring the project.
2. **Coroutines** : Used for asynchronous or non-blocking programming.
3. **RoomDB** : Used for storing images and populating when no internet is available.
4. **Retrofit2** : Used for calling Imgur Gallery API.
5. **LiveData** : Used for reactive programming
6. **Glide** : Used for loading gallery images.
