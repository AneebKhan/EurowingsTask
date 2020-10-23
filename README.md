# EurowingsTask
Eurowings Android Developer Test
<p align="center"><img src="https://thedesignair.files.wordpress.com/2015/01/eurowings.jpg" ></a></p>

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

## Notes
Total duration: ~8h.
- Paper prototyping: ~30'
- Search for assets online: ~30'
- Setup project: ~15'
- Setup project dependecies:  ~15'
- Setup project architecutre: ~2h
- Model creation: ~40'
- Base classes: ~40'
- Main Screen UI: ~40'
- Filter Mechanism: ~2h

Decision made because of restricted time/improvements with more time:
- Use of RxJava.
- Use of Dagger2 for DI
- Better error handling.
- Implentaion of Unit and UI testing but i tried to write as much testable code as possible.

