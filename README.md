# CD Library

## Wstępne założenia

- klasa płyta: tytuł płyty, wykonawca, lista gatunków, rok wydania, lista utworów, czas łączny - wyliczane przez metodę
- gatunek: typ wyliczeniowy
- klasa biblioteka - kolekcja płyt, metody dodawanie płyty, usuwanie płyty, wyszukiwanie na podstawie kryteriów: szukaj po tytule płyty, szukaj po tytule utworu, szukaj po gatunkach, szukaj po roku wydania, zapis danych na dysk, odczyt z dysku, pliki tekstowe
- klasa utwór: tytuł, długość w sekundach, kompozytor, autor tekstu

## Obsługa przy pomocy menu tekstowego

1. dodaj nową płytę
2. usuń płytę
3. wyświetl wszystkie płyty
4. wyszukaj płyty po tytule płyty
5. wyszukaj utwory po tytule utworu
6. wyszukaj płyty po tytule utworu
7. wyszukaj płyty po gatunku
8. wyszukaj utwory po gatunku
9. wyszukaj płyty po roku wydania
10. wyjdź z programu

## Format pliku z danymi

1. N - liczba płyt w bibliotece
2. tytuł 1
3. artysta 1
4. M1 - liczba utworów 1 płyty
5. tytuł 1 utworu
6. czas 1 utworu
7. gatunek 1 utworu
8. etc
9. etc
10. etc
11. tytuł 2 utworu
12. etc
-- powtórzone M1 razy
...
XX. rok wydania 1
tytuł 2
artysta 2
etc
M2 - liczba utworów 2 płyty


--- powtórzone N razy
