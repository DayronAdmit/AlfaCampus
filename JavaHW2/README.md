# Домашнее задание по первым двум лекциям по ООП

**Что делать:**

0. Подключить модуль как gradle-проект. Для этого проваливаемся в папку *JavaHW2*, находим в ней файл **build.gradle** и 
через правую кнопку мыши выбираем пункт **"Link Gradle Project"**
1. В пакете *person* в классе **Person** задать поля: имя, фамилия и год рождения. Добавить конструктор для всех полей класса.
Добавить геттеры.
2. В пакете *phone* в классе **Phone** задать поля: модель, номер телефона, владелец - должен быть типа Person. Добавить 
конструкторы: пустой, принимающий только модель, принимающий модель и номер телефона, принимающий все поля.
3. Переопределить метод *toString()* в классе **Person** чтобы на выходе получить вывод строки в формате: 
*Фамилия: Петров; Имя: Петр*. Написать программу, которая создает два объекта класса **Person** и выводит на экран фамилию 
и имя
4. Написать программу, которая создает 4 объекта класса **Phone** (из всех конструкторов) и выводит каждый объект на экран
5. В классе **Phone** добавить методы: - получения модели телефона - изменения и получения номера телефона - вывода 
полной информации о телефоне в строке формата: "Владелец телефона: Вася Иванов. Модель: iphone13. Номер телефона: +79267737272"

**Доп задания** - можно получить еще 1 балл:
1. В пакете *animal* необходимо реализовать абстрактный класс домашних животных - **Pet**. Каждое домашнее животное может: 
- спать *sleep()* - при вызове должно выводиться слово "я сплю"
- играть *play()* - при вызове должно выводиться слово "я играю"
- издавать какой-то звук *makeSound()*
- также у всех домашних животных есть свойство - кол-во лапок - *pawsConunt*
Необходимо создать класс кошки **Cat**, которая может поймать мышку *cathcMouse()* - выводим "Поймала мышку"; класс хомяка 
**Hamster**, который может спрятать еду *hideFood()* - выводим "Вся еда моя" и класс собаки **Dog**, которая может принести палку *bringStick()* - 
выводим - "Я принес палку"
В ходе выполнения программы создать по одному домашнему животному каждого вида, вызвать все методы и распечатать кол-во лапок. 

В домашней работе есть **тесты**. При сдаче работы необходимо **приложить скриншот результатов тестов в МР**. 
Добавлять скрины **в проект не нужно**, нужно только добавить их в описание МР-а. 
Изначально тесты не рабочие и будут падать если вы будете их запускать. По мере выполнения домашней работы тесты будут
**зеленеть**. 
По итогу все тесты должны пройти. НО, если по какой-то причине не получается доделать дз или выполнена только часть дз и 
какие-то тесты остаются красными, то все равно прикладываем скриншот, просто в нем будут и упавшие тесты тоже.