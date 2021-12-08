# Snake Game

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

**Projek ini merupakan projek yang dibuat oleh Kelompok B-06, Kelas Pemrograman Berorientasi Objek, Teknik Informatika Universitas Padjadjaran. Projek ini mengimplementasikan javaFX dan Gradle. Projek ini dibuat untuk memenuhi tugas akhir (final project) kelas Pemrograman Berorientasi Objek, Teknik Informatika Universitas Padjadjaran.**

## Credits
| NPM          | Name                   |
| ------------ | ---------------------- |
| 140810200022 | Osmond Haylim          |
| 140810200024 | Jonathan Victor Goklas |
| 140810200002 | Rommel Malik Kusnadi   |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (16/11/2021)** 
   - Diskusi awal
   - perencanaan changelog

- **[Sprint 1](changelog/sprint-1.md) - (date from 16/11/2021 to 22/11/2021)** 
   - Menginisiasi projek

- **[Sprint 2](changelog/sprint-2.md) - (date from 23/11/2021 to 30/11/2021)** 
   - Membuat board
   - Membuat objek,logika Snake
   - Membuat objek,logika Food
   - Membuat input jalan Snake
   - Membuat sistem skor
   
- **[Sprint 3](changelog/sprint-3.md) - (date from 01/12/2021 to 07/12/2021)** 
   - Leaderboard

## Running The App

Untuk memulai aplikasi, pertama kita gradle run, lalu kita dapat jalankan Snake dengan menekan spasi pada keyboard. Untuk menggerakkan Snake, kita gunakan arrow pada keyboard.

## Classes Used

- Painter.java = Sebagai paint dari scene
- SnakeGame.java = Sebagai main dari projek
- Board.java = Sebagai board dari projek
- Fuud.java = Sebagai objek dari Food
- GameLoop.java = Sebagai logika game Snake
- Leaderboard.java = Sebagai leaderboard game
- Point.java = Sebagai logika dari koordinat x dan y
- Score.java = Sebagai logika dari skor Snake
- Snek.java = Sebagai objek dari Snake

![UML project oop](https://media.discordapp.net/attachments/412931424069484544/917956551958990918/UML_SnakeGame.drawio.png?width=566&height=569)

## Notable Assumption and Design App Details

Aplikasi game Snake menggunakan javaFX
