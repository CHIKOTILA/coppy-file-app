# coppy-file-app

## Введение

coppy-file-app - это приложение с графическим интерфейсом, разработанное на Java с использованием JavaFX и JNI (Java Native Interface). Оно предназначено для удобного копирования файлов из одной директории в другую, позволяя пользователю легко копировать файлы с помощью интуитивного графического интерфейса.
JNI используется для создания файла с доскрипторами перемезаемой папки в операционных системах Windows(10 и выше).

## Необходимые условия для использования продукта

Прежде чем начать использовать приложение, убедитесь, что ваша система удовлетворяет следующим требованиям:

- Java Development Kit (JDK) версии 17 или выше должен быть установлен на вашем компьютере.
- JavaFX должен быть доступен на вашей системе.

## Как установить программу

1. Скачайте репозиторий coppy-file-app с GitHub.
2. Убедитесь, что у вас установлен JDK версии 17 или выше.
3. Проверьте наличие JavaFX на вашей системе.
4. Скомпилируйте исходный код с помощью команды:


javac -cp path/to/javafx-sdk-VERSION/lib/* src/com/example/relocateapp/*.java


Где path/to/javafx-sdk-VERSION - путь к установленной библиотеке JavaFX.

6. Добавить файл nativelib.dll в папку path/to/javafx-sdk-VERSION/bin 

7. Запустите приложение с помощью команды:


java -cp path/to/javafx-sdk-VERSION/lib/*:src com.example.relocateapp.Main


//Так же можно запустить открыв папку в IDE

## Порядок использования

1. После запуска приложения откроется окно с графическим интерфейсом.
2. Введите путь к исходной директории в поле "From".
3. Введите путь к целевой директории в поле "To".
4. Выберите файлы, которые вы хотите переместить, вручную введите пути к файлам.
5. Нажмите кнопку "Relocate" для переноса выбранных файлов в указанную целевую директорию.
