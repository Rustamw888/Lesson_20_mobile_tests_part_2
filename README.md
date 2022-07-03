# Проект по автоматизации тестирования 
## <a target="_blank" href="https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk">мобильного приложения Wikipedia</a>

![This is an image](https://i.imgur.com/ZArRjuS.png)

## :rocket: Содержание:

- [x] <a href="#rocket-технологии-и-инструменты">Технологии и инструменты</a>
- [x] <a href="#rocket-реализованные-проверки">Реализованные проверки</a>
- [x] <a href="#rocket-сборка-в-Jenkins">Сборка в Jenkins</a>
- [x] <a href="#rocket-запуск-из-терминала">Запуск из терминала</a>
- [x] <a href="#rocket-allure-отчет">Allure отчет</a>
- [x] <a href="#rocket-Результаты-тестов-в-BrowserStack">Результаты тестов в BrowserStack</a>
- [x] <a href="#rocket-видео-примеры-прохождения-тестов">Видео примеры прохождения тестов</a>

## :rocket: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Android Studio" src="images/logo/android-studio.svg">
<img width="6%" title="Appium" src="images/logo/appium.svg">
<img width="6%" title="BrowserStack" src="images/logo/browserstack.svg">
</p>

## :rocket: Реализованные проверки
![This is an image](https://i.imgur.com/Dd62Cq5.png)
- Переход на каждую из основных страниц приложения
- Работоспособность системы поиска
- Наличие основных элементов в результате поиска

## :rocket: Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/Lesson_20_mobile_tests_part2/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins_dashboard.png">
</p>

### Параметры сборки в Jenkins:
Сборка в Jenkins

- устройство, по умолчанию Pixel 4 API 30
- версия ОС, по умолчанию Android 11.0

## :rocket: Запуск из терминала
Локальный запуск:
```
gradle clean screen -Dhost=(browserStack/realDevice/androidEmulator)
```

Удаленный запуск:
```
clean
screen
"-Dhost=${HOST}"
```

## :rocket: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/report_main_page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/report_tests_page.png">
</p>

## :rocket: Результаты тестов в BrowserStack
- ### Экран с результатами запуска тестов
<p align="center">
<img title="TestOps Launch Page" src="images/screenshots/browserstack_launch_page.png">
</p>

- ### Вкладка с текстовыми логами в BrowserStack
<p align="center">
<img title="TestOps tests page" src="images/screenshots/browserstack_text_logs_1.png">
<img title="TestOps tests page" src="images/screenshots/browserstack_text_logs_2.png">
<img title="TestOps tests page" src="images/screenshots/browserstack_text_logs_3.png">
</p>

- ### Вкладка с логами устройства в BrowserStack
<p align="center">
<img title="TestOps tests page" src="images/screenshots/browserstack_device_logs.png">
</p>
# curl -u login:password https://api.browserstack.com/app-automate/builds/094671bce1f45532bd0227b1bc3530a36c7797a6/sessions/ad43656ff296ce33beb4390ccd2b29eb74c03976/devicelogs

- ### Вкладка с логами appium в BrowserStack
<p align="center">
<img title="TestOps tests page" src="images/screenshots/browserstack_appium_logs.png">
</p>
# curl -u login:password https://api.browserstack.com/app-automate/builds/094671bce1f45532bd0227b1bc3530a36c7797a6/sessions/ad43656ff296ce33beb4390ccd2b29eb74c03976/appiumlogs

- ### Вкладка состояния устройства в BrowserStack
<p align="center">
<img title="TestOps tests page" src="images/screenshots/app_profiling.png">
</p>

## :rocket: Видео примеры прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gifs/test_result.gif">
</p>



