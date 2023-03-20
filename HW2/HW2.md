С чем мы работаем?
http://qa-games.ru/ - наше приложение, с которым мы работаем.
Это приложение представляет из себя ленту с постами различных пользователей.

Предполагается, что пользователь приложения может:
1. создать свою учетную запись
2. в рамках своей учетной записи:
3. создавать посты
4. редактировать свои посты
5. удалять свои посты
6. просматривать добавленные другими пользователями посты
7. осуществлять поиск по постам

Бизнес-цель данного приложения - создать альтернативу платформе Tumblr, на некоммерческой основе, и вернуть фанатам их 2013-2017.

Как мы с этим работаем?
Для входа в приложение и получения доступа к контенту:
выбираем вкладку АВТОРИЗАЦИЯ
вбиваем Логин - Пароль.
Используйте пару в соответствии с номером того зала, в который вы попали на лекции 24/11/22
user1@example.com -> Wan-Rockslide
user2@example.com -> require-Absorb
user3@example.com -> Superbowl-recipe
user4@example.com -> masque-True
user5@example.com -> diana-Sifts
user6@example.com -> neutron-Campus
user7@example.com -> rune-Bebop

Используем данные лекционной практики от 24/11/22:
https://docs.google.com/spreadsheets/d/1-EveZg29tmtl4ahx7DfWmaLm3aKO0e5rgHOkK68LXPc/edit?usp=sharing - таблица с результатами работы на занятии

ДОМАШНЕЕ ЗАДАНИЕ

Часть 1.
ПРЕРЕКВИЗИТЫ:
Цель
Провести исследовательское тестирование (exploratory testing) http://qa-games.ru/
Вводная
Тема лекции была заявлена как тест-дизайн. Основные задачи ДЗ:
предоставить возможность получить опыт структурирования своей работы на базе проведения исследовательского тестирования (exploratory testing)
запустить механизм рефлексии и сделать выводы из:
собственного практического опыта на лекции 24/11/22
результатов работы коллег
осознать значение понятий “ресурс”, “стратегия” и их значимость для работы  QA-инженера

Перед выполнением ДЗ настоятельно рекомендую ознакомиться с https://www.satisfice.com/exploratory-testing, чтобы преисполниться и сфокусироваться именно на том, что от вас ожидают, а именно на организации системного подхода к исследовательскому тестированию.

От вас ожидается работа по применению навыков исследовательского тестирования.

Сценарное vs. исследовательское тестирование
Сценарное тестирование: создание тест-кейса – исполнение – сравнение результата с ожидаемым результатом/требованиями
Исследовательское тестирование: исследовать приложение – отметить недостатки – спроектировать тест-кейс – выполнить тест-кейс – повторить

Исследовательское тестирование — это творческий подход, основанный на опыте, при котором проектирование (design), выполнение и обучение являются одновременными действиями. Вам осознанно не ставятся рамки и ограничения в виде требований на данном этапе, для того, чтобы вы ощутили “суть” тестирования и никогда больше не подразумевали под ним “поиск багов”, “выявление дефектов” и чуть лучше поняли часть определения про “процесс направленный на проверку соответствия требованиям явным и неявным, ожиданиям пользователя…”

Исследовательское тестирование не означает, что тестировщики приступают к тестированию приложения случайным образом (это будет AD HOC тестирование). Исследовательское тестирование предполагает стратегию или тест-дизайн с применением различных техник и инструментов:
определение ресурса
анализ входящих данных (что имеем на входе)
оценку приложения с разных точек зрения, таких как:
набор функций приложения
действия и результаты
типы учетных записей и многое другое
Предполагаемая структура подхода
Ключевым преимуществом исследовательского тестирования является то, что оно может носить произвольный характер. Ниже опишу верхнеуровневую абстрактную структуру:
Исследование
Изучите приложение изнутри и снаружи — цель, целевой рынок, как его можно сломать, что мог упустить разработчик и заказчик
Дизайн
Наметьте различные методы, техники тест-дизайна, инструменты для проверок, объем тестирования на уровнях и т.д.
Выполнение
Проверьте все распространенные случаи (граничные значения, проверки, etc.).
Report
Предоставьте отчеты - фиксируйте результаты своей деятельности. В будущем они помогут вам при работе с требованиями и разбором дефектов


Рекомендую полностью прочитать ДЗ файлик перед тем, как приступать к этой части ДЗ.
Рекомендую выполнить эту часть ДЗ первой, перед основной частью.


ЗАДАНИЕ:
откройте результаты лекционной практики https://docs.google.com/spreadsheets/d/1-EveZg29tmtl4ahx7DfWmaLm3aKO0e5rgHOkK68LXPc/edit?usp=sharing
откройте лист 4 с результатами работы группы 4
сравните результаты работы вашей группы с результатами работы группы 4
выделите сходства и различия
отметьте позитивные расхождения: “что с вашей точки зрения группе 4 удалось особенно хорошо?”, “почему вы считаете, что это “хорошо”?”
выдвинете гипотезу к каждому из таких различий: “что они такого сделали, что у них получилось вот так круто? что не сделали мы в своей групповой работе?”
ответьте для себя на вопрос “буду ли я использовать это в своей дальнейшей работе и как?” - ответ письменно фиксировать не требуется
зафиксируйте ваши ответы в виде списка с пояснениями, например:
Сходства
одинаковые ТТД
Различия
зафиксировали результат
Что делали: последовательно заполняли ячейки по горизонтали
Почему важно: группа 4 сможет не тратить время и сразу сравнить свой отчет с требованиями, когда/если те поступят

Часть 2.
Практика и приложение выводов рефлексии
Задачи
1. провести исследовательское тестирование ВСЕГО приложения http://qa-games.ru/
2. описать стратегию
   уделите внимание ТТД при описании стратегии, закрепите материал лекции
   зафиксировать результаты в виде отчета о тестировании
   НЕ ЗАВОДИТЬ БАГ РЕПОРТЫ НЕ ИСКАТЬ БАГИ - если в ДЗ будет баг-репорт - будет 0 за ДЗ

Советы (возможно вредные)
Разделите приложение на модули для упрощения тестирования и более эффективного покрытия тестами
Составьте контрольный список всех функций, которые необходимо протестировать, чтобы ничего не упустить
Загуглите чек-листы проверок вашего типа приложения
Начните с тестирования основных пользовательских сценариев. Расширяйте список по ходу тестирования, добавляя в тест дополнительные функции и новые факторы.
Проверьте графический интерфейс на соответствие стандартам
Ставьте перед собой конкретную задачу на определенный промежуток времени / тестовый сеанс: “сейчас я делаю вот это, результат я фиксирую вот так”
Ведите учет того, что необходимо протестировать, почему и как оценить его качество.
Ведите учет проблем, возникших во время тестов - note the flaws, do not report bugs!
Объединяйтесь в пары или группы для эффективного тестирования
Создавайте документацию по ходу исследования приложения

Эти слова здесь абсолютно случайно, чтобы вы их точно НЕ гуглили
boundary value analysis, equivalence technique, risk-based technique, cause effect graphing technique, domain testing, strategy-based Exploratory Testing