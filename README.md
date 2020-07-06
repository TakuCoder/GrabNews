# GrabNews
News App build using MVVM architecture, Dagger2 for dependecy injection, Room for persistence with Rxjava and Material Design for UI.
#Steps to build the project
1. Replace <YOUR_API_KEY> with your APIKEY generated from https://newsapi.org/ on app\build.gradle under buildtypes

debug {
            buildConfigField "String", "API_KEY", '"<YOUR_API_KEY>"'
            ...
            ...
        }
2. sync
