# Racewars

Ihre überragende Fähigkeiten in der Programmierung macht in der Spielbranche die Runde, weshalb Sie nun ein Angebot des Spielgiganten Blizzard auf Ihrem Schreibtisch liegen haben, ein neues rundenbasiertes Rollenspiel zu entwerfen.

Da Sie selbst leidenschaftlicher Zocker sind, nehmen Sie diese Herausforderung natürlich sofort dankend an.

## Rassen

Bei dem Spiel geht es um den Kampf zwischen unterschiedlichen Wesen aus einer dunklen Fantasywelt. In dem Spiel gibt es vier verschiedene Rassen zur Auswahl.

Alle Rassen haben wichtige Gemeinsamkeiten: Dazu gehören **Lebenspunkte**, **Rüstung**, **Schaden**, **Geschwindigkeit**.

Anführer besitzen zusätzlich ein **dominiertes Element**. Die Elemente sind

  * **Feuer**
  * **Wasser**
  * **Luft**
  * **Erde**.

Weitere Elemente gibt es nicht.

### Orks

Da wären zum einen die Orks, die die Eigenschaft besitzen sehr stark zu sein. Ein Ork kostet **150 $**.

<img src="img/orc.png" height="180">

Der Anführer der Ork-Horden ist der Anführer **Farseer**. Sein dominiertes Element ist **Erde** und er kostet im Spiel **300 $**.

<img src="img/farseer.png" height="140">


### Untote

Eine weitere Rasse sind die Untoten. Die einzelnen Wesen sind sehr günstig (**70 $**) und nicht besonders stark oder schnell. In der Masse sind sie aber stark.

<img src="img/zombie.png" height="180">

Die Anführerin der Untoten ist die dunkle **Lich**, der das Element **Wasser** dominiertes und **140 $** kostet.

<img src="img/lich.png" height="180">


### Menschen

Des Weiteren gibt es die Menschen. Diese sind sehr ausdauernd, was bedeutet, dass sie größeren Schaden als andere Wesen einstecken können. Sie kosten **110 $**.

<img src="img/human.png" height="180">

Die Menschen regiert der **Erzmagier**. Er führt sein Gefolge in die Schlacht und dominiert das Element **Feuer**. Der Erzmagier kostet **220 $**.

<img src="img/wizard.png" height="150">


### Nachtelfen

Zu guter Letzt gibt es noch die Nachtelfen, welche die Eigenschaft besitzen sehr intelligent zu sein. Man kann Sie für **145 $** erwerben.

<img src="img/elf.png" height="180">

Der mächtigste Elf ist der **Daemonslayer**, der das Element **Luft** kontrolliert und **290 $** kostet.

<img src="img/daemonslayer.png" height="140">


### Geister

Neben den dargestellten Rassen gibt es noch **Geister**. Diese können nicht aktiv von den Spielern eingesetzt werden, sie trete aber trotzdem teilweise auf und greifen in Kämpfe (s.u.) ein.

<img src="img/ghost.png" height="180">

Geister besitzen keine der beschriebenen Eigenschaften oder Methoden, können aber trotzdem über `attacke(Wesen r)` (siehe unten) an Kämpfen teilnehmen. Da sie nur ätherische Wesen sind, kann man sie nicht töten, sie ziehen dem Gegner aber grundsätzlich einen Lebenspunkt ab. Man kann Geister nicht in sein Squad aufnehmen, sondern sie werden vom Spielsystem in den Kampf geschickt.


## Übersicht über die Attribute

Die Wesen haben einige Eigenschaften, die in den folgenden Tabellen zusammengefasst sind.

Während des Spiels kann man einzelne Wesen kaufen, hierfür ist der folgende Kaufpreis zu zahlen.

**Tabelle: Kosten für die Wesen**

| Art          | Kosten |
|--------------|--------|
| Ork          | 150 $  |
| Farseer      | 300 $  |
| Untote       |  70 $  |
| Lich         | 140 $  |
| Mensch       | 110 $  |
| Erzmagier    | 220 $  |
| Nachtelf     | 145 $  |
| Daemonslayer | 290 $  |

Allen Wesen gemeinsam sind die Eigenschaften **Lebenspunkte**, **Schaden**, **Geschwindigkeit** und **Rüstung**. Diese sind wie folgt belegt:

**Tabelle: Fähigkeitswerte der Wesen**

| Art      | Lebenspunkte | Schaden | Geschwindigkeit | Rüstung |
|----------|--------------|---------|-----------------|---------|
| Ork      | 100          | 33      | 1               | 30%     |
| Untote   | 120          | 16      | 2               | 30%     |
| Mensch   | 140          | 40      | 2               | 40%     |
| Nachtelf | 120          | 15      | 3               | 20%     |

Die Zuordnung zwischen Anführer und Element ist:

**Tabelle: Elemente der Anführer**

| Anführer     | Element |
|--------------|---------|
| Farseer      | Erde    |
| Lich         | Wasser  |
| Erzmagier    | Feuer   |
| Daemonslayer | Luft    |

Die Anführer besitzen zusätzlich einen **Bonus Faktor**. Dieser wird auch als Multiplikator für die Lebenspunkte verwendet.

**Tabelle: Bonus der Anführer**

| Anführer     | Bonus |
|--------------|-------|
| Farseer      | 1,2   |
| Lich         | 2,3   |
| Erzmagier    | 5,0   |
| Daemonslayer | 3,0   |


## Spielstart

Von den Anführern der jeweiligen Rassen (`Farseer`, `Lich`, `Erzmagier` und `Daemonslayer`) darf es **immer nur ein einziges Objekt** geben. Ergreifen Sie entsprechende Maßnahmen, um dies in Ihrem Programm sicherzustellen.

Vor Spielstart müssen sich zwei Spieler einen `Squad` zusammenstellen, welches Wesen aus maximal zwei unterschiedlichen Rassen enthält. In einem Squad können beliebig viele Wesen der jeweiligen Rasse vorhanden sein, der Anführer aber nur einmal. Die Anzahl der Wesen wird durch deren Kosten begrenzt. Jeder Spiele hat einen festen Geldbetrag von **2000 $**. Mit diesem kann er Wesen für seinen Squad kaufen.

Der Spieler gibt seinem Squad neben den Wesen noch die Information mit, wie es heißen soll. Diesen Namen kann er frei wählen (z.B. "The walking dead").

Die Instanzen der einzelnen Wesen werden über eine Factory (`WesenFactory`) erzeugt. Eine direkte Erzeugung ist nicht möglich, d.h. insbesondere, dass die Klassen der einzelnen Wesen (Mensch etc.) **nicht `public`** sind. Der Factory übergibt man die Information, wie viel Geld man investieren möchte und sie gibt ein Array von Wesen zurück. Das erste Element ist immer der Anführer, die folgenden dann entsprechend die Wesen der Art. Reicht das Geld nicht, wird ein leeres Array zurückgegeben. Die Art der erzeugten Wesen wählt man über einen passenden Parameter (`rasse`) aus.

Jede Rasse verfügt über die Methode `attacke`, sodass ein Angriff auf einen anderen Kämpfer ausgeführt werden kann. Diese Methode gibt den angerichteten Schaden zurück und zieht gleichzeitig diesen von den Lebenspunkten des Gegners ab.

Jede Rasse verfügt zudem über die Methoden `isLebendig()`, die angibt, ob ein Wesen noch lebt, d.h. die Anzahl der Lebenspunkte > 0 ist. Ist ein Wesen nicht mehr lebendig, wird es aus dem Squad entfernt.

Weiterhin gibt es eine Methode `beschraenkeSchaden(double damage)`. Bei Menschen führt diese Methode dazu, dass der angerichtete Schaden prozentual um den 10% verringert wird. Bei anderen Wesen hat sie keine Wirkung.

Ein weiteres wichtiges Kriterium ist, dass die spezifischen Eigenschaften (**außer den aktuellen Lebenspunkten eines Wesens**) der einzelnen Rassen unveränderbar nach Objekterstellung sind und von der Basisklasse `Wesen` generell kein Objekt erstellt werden darf.

Ordnen Sie die verschiedenen Wesen **sinnvoll in Pakete** ein.


## Kampfsystem

Nun zur generellen Kampflogik des Spiels. Die Schadenshöhe einer Rasse berechnet sich wie folgt:

\( damage = Geschwindigkeit \cdot Schaden \)

Wobei letzterer bei den Menschen, wie schon erwähnt, über die Methode `beschraenkeSchaden` beschränkt wird, da diese mehr Schaden ertragen als andere Klassen. Achten Sie daher darauf den errechneten Schaden bei den Menschen um diesen Faktor zu reduzieren.

Jeder **Anführer** erhöht diesen Schaden nun noch einmal um seinen jeweiligen Bonus Faktor.

\( damage = damage \cdot bonus \)

Sollte der Anführer auf einen anderen Anführer treffen und dessen Element überlegen sein, wird der Schaden noch einmal verdoppelt. Hierbei gilt:

  * Feuer ist Luft überlegen,
  * Wasser ist Feuer überlegen,
  * Erde ist Wasser überlegen,
  * Luft ist Erde überlegen.

Nachdem der Schaden errechnet wurde, muss noch wie oben angedeutet die **Rüstung** beachtet werden. Das heißt, der angerichtete Schaden muss prozentual der angegebenen Rüstung reduziert und anschließend von den Lebenspunkten abgezogen werden.

\( damage = damage \cdot (1 - gegnerruestung) \)


## GameController

Die Haupt-Klasse `GameController` enthält die `main`-Methode, erstellt die Squads und besitzt die Kenntnis über die aktuelle Runde sowie den Spieler, der an der Reihe ist. Außerdem startet ihre Methode `runGame()` das Spiel. In dieser wird in einer Schleife jeweils die Attacke eines Squad auf das andere ausgeführt (und umgekehrt), und jeweils der aktuelle Spielstand sowie Runde über die statische Methode `printGame(GameController game)` des `GameViewers` ausgegeben. Jedes Wesen eines Squads führt eine Attacke auf eine zufällig gewählte Wesen des Gegner-Squads durch. Wenn das Spiel gestartet wurde, läuft es ohne Nutzereingaben bis zur kompletten Auslöschung eines Squads und terminiert mit der Ausgabe des Gewinners. Bei jedem Kampf werden die Ergebnisse der Begegnung und die Auswirkung auf den Squad angezeigt.

Die Geister brauchen Sie in der Simulation nicht vorzusehen. Es reicht, die Klasse anzulegen.

Überschreiben Sie die `toString`-Methoden so, dass sinnvolle Informationen zu den einzelnen Wesen ausgegeben werden können.

Nehmen Sie **keine Eingaben von der Konsole** entgegen. Das Spiel läuft automatisch nach dem Start durch.


## UML-Diagramm

Erstellen Sie ein Klassendiagramm (z.B. in Eclipse Papyrus), das die im Text genannten Entitäten, Eigenschaften und Methoden in einem objektorientierten Modell abbildet. Lesen Sie den Text sehr sorgfältig, um keine Klassen oder Interfaces bzw. Beziehungen zu vergessen.

Nutzen Sie Vererbung und abstrakte Klassen, um keine Information und kein Verhalten mehr als einmal abbilden zu müssen. Sie werden höchstwahrscheinlich noch eigene, über die im Text genannten Entitäten herausgehende Abstraktionen einführen wollen, um das Design zu vervollständigen. Teilen Sie die entworfenen Strukturen in verschiedene Pakete auf, und wählen Sie sinnvolle Sichtbarkeitsattribute.

**Abgabe**: Das UML-Diagramm ist Teil der Abgabe und sollte an einer geeigneten Stelle in Ihrem Repository eingecheckt sein. Als **Dateiformat** ist `PNG` oder `PDF` erlaubt.


## Implementierung

Gehen Sie in das Paket [pr2.vererbung.racewars](../sources/src/main/java/pr2/vererbung/racewars/).

Implementieren Sie alle Klassen aus Ihrem UML-Diagramm mit dem entsprechenden Verhalten.


## JUnit

Schreiben Sie sinnvolle JUnit Tests zur Überprüfung der Factories, der Kampf-Funktion und der Erstellung verschiedener Squads.


## Simulation

Simulieren Sie eine Schlacht mit einer gewissen Anzahl an Einheiten, jedoch aber gleichem Startkapital (2000 $) beider Squads. Machen Sie entsprechende Ausgaben, aus denen hervorgeht, dass sich Ihr Programm wie spezifiziert verhält.

Eine beispielhafte Ausgabe des Spiels sieht wie folgt aus:

```console

---------RUNDE 1-------
---------RUNDE 1-------
Squad von: The walking dead
  Squadgröße: 18
    🌟 Lich Untoter [276.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [120.00]
    🌟 Farseer Ork [120.00]
    Ork [100.00]
    Ork [100.00]
    Ork [100.00]
    Ork [100.00]

Squad von: Legolas and friends
  Squadgröße: 13
    🌟 Erzmagier Mensch [700.00]
    Mensch [140.00]
    Mensch [140.00]
    Mensch [140.00]
    Mensch [140.00]
    Mensch [140.00]
    Mensch [140.00]
    Mensch [140.00]
    🌟 Daemonslayer Nachtelf [360.00]
    Nachtelf [120.00]
    Nachtelf [120.00]
    Nachtelf [120.00]
    Nachtelf [120.00]

⚔️⚔️⚔️⚔️⚔️⚔️⚔️ Kampf ⚔️⚔️⚔️⚔️⚔️⚔️⚔️
🌟 Erzmagier Mensch [700.00] ⚔️ Untoter [120.00] -> Schaden: 280.00
   🌟 Erzmagier Mensch [700.00], Untoter ☠☠☠
Mensch [140.00] ⚔️ 🌟 Farseer Ork [120.00] -> Schaden: 56.00
   Mensch [140.00], 🌟 Farseer Ork [64.00]
Mensch [140.00] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [64.00]
Mensch [140.00] ⚔️ 🌟 Lich Untoter [276.00] -> Schaden: 56.00
   Mensch [140.00], 🌟 Lich Untoter [220.00]
Mensch [140.00] ⚔️ Ork [100.00] -> Schaden: 56.00
   Mensch [140.00], Ork [44.00]
Mensch [140.00] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [64.00]
Mensch [140.00] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [64.00]
Mensch [140.00] ⚔️ Untoter [64.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [8.00]
🌟 Daemonslayer Nachtelf [360.00] ⚔️ 🌟 Lich Untoter [220.00] -> Schaden: 94.50
   🌟 Daemonslayer Nachtelf [360.00], 🌟 Lich Untoter [125.50]
Nachtelf [120.00] ⚔️ Untoter [120.00] -> Schaden: 31.50
   Nachtelf [120.00], Untoter [88.50]
Nachtelf [120.00] ⚔️ Untoter [120.00] -> Schaden: 31.50
   Nachtelf [120.00], Untoter [88.50]
Nachtelf [120.00] ⚔️ Untoter [120.00] -> Schaden: 31.50
   Nachtelf [120.00], Untoter [88.50]
Nachtelf [120.00] ⚔️ Untoter [88.50] -> Schaden: 31.50
   Nachtelf [120.00], Untoter [57.00]
🌟 Lich Untoter [125.50] ⚔️ Mensch [140.00] -> Schaden: 63.59
   🌟 Lich Untoter [125.50], Mensch [76.41]
Untoter [88.50] ⚔️ Mensch [140.00] -> Schaden: 17.28
   Untoter [88.50], Mensch [122.72]
Untoter [120.00] ⚔️ Mensch [122.72] -> Schaden: 17.28
   Untoter [120.00], Mensch [105.44]
Untoter [57.00] ⚔️ Nachtelf [120.00] -> Schaden: 25.60
   Untoter [57.00], Nachtelf [94.40]
Untoter [120.00] ⚔️ Mensch [140.00] -> Schaden: 17.28
   Untoter [120.00], Mensch [122.72]
Untoter [64.00] ⚔️ 🌟 Erzmagier Mensch [700.00] -> Schaden: 17.28
   Untoter [64.00], 🌟 Erzmagier Mensch [682.72]
Untoter [120.00] ⚔️ Nachtelf [120.00] -> Schaden: 25.60
   Untoter [120.00], Nachtelf [94.40]
Untoter [120.00] ⚔️ Nachtelf [94.40] -> Schaden: 25.60
   Untoter [120.00], Nachtelf [68.80]
Untoter [88.50] ⚔️ Nachtelf [94.40] -> Schaden: 25.60
   Untoter [88.50], Nachtelf [68.80]
Untoter [8.00] ⚔️ Nachtelf [120.00] -> Schaden: 25.60
   Untoter [8.00], Nachtelf [94.40]
Untoter [120.00] ⚔️ 🌟 Daemonslayer Nachtelf [360.00] -> Schaden: 25.60
   Untoter [120.00], 🌟 Daemonslayer Nachtelf [334.40]
Untoter [64.00] ⚔️ Mensch [76.41] -> Schaden: 17.28
   Untoter [64.00], Mensch [59.13]
🌟 Farseer Ork [64.00] ⚔️ Mensch [122.72] -> Schaden: 21.38
   🌟 Farseer Ork [64.00], Mensch [101.34]
Ork [100.00] ⚔️ 🌟 Erzmagier Mensch [682.72] -> Schaden: 17.82
   Ork [100.00], 🌟 Erzmagier Mensch [664.90]
Ork [100.00] ⚔️ Nachtelf [68.80] -> Schaden: 26.40
   Ork [100.00], Nachtelf [42.40]
Ork [100.00] ⚔️ Nachtelf [120.00] -> Schaden: 26.40
   Ork [100.00], Nachtelf [93.60]
Ork [44.00] ⚔️ Mensch [59.13] -> Schaden: 17.82
   Ork [44.00], Mensch [41.31]
⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️


---------RUNDE 2-------
Squad von: The walking dead
  Squadgröße: 17
    🌟 Lich Untoter [125.50]
    Untoter [88.50]
    Untoter [120.00]
    Untoter [57.00]
    Untoter [120.00]
    Untoter [64.00]
    Untoter [120.00]
    Untoter [120.00]
    Untoter [88.50]
    Untoter [8.00]
    Untoter [120.00]
    Untoter [64.00]
    🌟 Farseer Ork [64.00]
    Ork [100.00]
    Ork [100.00]
    Ork [100.00]
    Ork [44.00]

Squad von: Legolas and friends
  Squadgröße: 13
    🌟 Erzmagier Mensch [664.90]
    Mensch [140.00]
    Mensch [140.00]
    Mensch [105.44]
    Mensch [41.31]
    Mensch [140.00]
    Mensch [101.34]
    Mensch [140.00]
    🌟 Daemonslayer Nachtelf [334.40]
    Nachtelf [68.80]
    Nachtelf [42.40]
    Nachtelf [93.60]
    Nachtelf [94.40]

⚔️⚔️⚔️⚔️⚔️⚔️⚔️ Kampf ⚔️⚔️⚔️⚔️⚔️⚔️⚔️
🌟 Erzmagier Mensch [664.90] ⚔️ 🌟 Lich Untoter [125.50] -> Schaden: 280.00
   🌟 Erzmagier Mensch [664.90], 🌟 Lich Untoter ☠☠☠
Mensch [140.00] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [64.00]
Mensch [140.00] ⚔️ Untoter [57.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [1.00]
Mensch [105.44] ⚔️ 🌟 Farseer Ork [64.00] -> Schaden: 56.00
   Mensch [105.44], 🌟 Farseer Ork [8.00]
Mensch [41.31] ⚔️ Ork [100.00] -> Schaden: 56.00
   Mensch [41.31], Ork [44.00]
Mensch [140.00] ⚔️ Ork [44.00] -> Schaden: 56.00
   Mensch [140.00], Ork ☠☠☠
Mensch [101.34] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [101.34], Untoter [64.00]
Mensch [140.00] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [64.00]
🌟 Daemonslayer Nachtelf [334.40] ⚔️ Ork [44.00] -> Schaden: 94.50
   🌟 Daemonslayer Nachtelf [334.40], Ork ☠☠☠
Nachtelf [68.80] ⚔️ Untoter [88.50] -> Schaden: 31.50
   Nachtelf [68.80], Untoter [57.00]
Nachtelf [42.40] ⚔️ 🌟 Farseer Ork [8.00] -> Schaden: 31.50
   Nachtelf [42.40], 🌟 Farseer Ork ☠☠☠
Nachtelf [93.60] ⚔️ Untoter [8.00] -> Schaden: 31.50
   Nachtelf [93.60], Untoter ☠☠☠
Nachtelf [94.40] ⚔️ Untoter [64.00] -> Schaden: 31.50
   Nachtelf [94.40], Untoter [32.50]
Untoter [57.00] ⚔️ Mensch [105.44] -> Schaden: 17.28
   Untoter [57.00], Mensch [88.16]
Untoter [64.00] ⚔️ Nachtelf [94.40] -> Schaden: 25.60
   Untoter [64.00], Nachtelf [68.80]
Untoter [1.00] ⚔️ Mensch [140.00] -> Schaden: 17.28
   Untoter [1.00], Mensch [122.72]
Untoter [64.00] ⚔️ Nachtelf [68.80] -> Schaden: 25.60
   Untoter [64.00], Nachtelf [43.20]
Untoter [32.50] ⚔️ 🌟 Erzmagier Mensch [664.90] -> Schaden: 17.28
   Untoter [32.50], 🌟 Erzmagier Mensch [647.62]
Untoter [64.00] ⚔️ Nachtelf [43.20] -> Schaden: 25.60
   Untoter [64.00], Nachtelf [17.60]
Untoter [120.00] ⚔️ Mensch [88.16] -> Schaden: 17.28
   Untoter [120.00], Mensch [70.88]
Untoter [88.50] ⚔️ 🌟 Erzmagier Mensch [647.62] -> Schaden: 17.28
   Untoter [88.50], 🌟 Erzmagier Mensch [630.34]
Untoter [120.00] ⚔️ Mensch [70.88] -> Schaden: 17.28
   Untoter [120.00], Mensch [53.60]
Untoter [64.00] ⚔️ Mensch [140.00] -> Schaden: 17.28
   Untoter [64.00], Mensch [122.72]
Ork [100.00] ⚔️ Nachtelf [93.60] -> Schaden: 26.40
   Ork [100.00], Nachtelf [67.20]
Ork [100.00] ⚔️ Mensch [101.34] -> Schaden: 17.82
   Ork [100.00], Mensch [83.52]
⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️


---------RUNDE 3-------
Squad von: The walking dead
  Squadgröße: 12
    Untoter [57.00]
    Untoter [64.00]
    Untoter [1.00]
    Untoter [64.00]
    Untoter [32.50]
    Untoter [64.00]
    Untoter [120.00]
    Untoter [88.50]
    Untoter [120.00]
    Untoter [64.00]
    Ork [100.00]
    Ork [100.00]

Squad von: Legolas and friends
  Squadgröße: 13
    🌟 Erzmagier Mensch [630.34]
    Mensch [122.72]
    Mensch [140.00]
    Mensch [53.60]
    Mensch [41.31]
    Mensch [122.72]
    Mensch [83.52]
    Mensch [140.00]
    🌟 Daemonslayer Nachtelf [334.40]
    Nachtelf [17.60]
    Nachtelf [42.40]
    Nachtelf [67.20]
    Nachtelf [68.80]

⚔️⚔️⚔️⚔️⚔️⚔️⚔️ Kampf ⚔️⚔️⚔️⚔️⚔️⚔️⚔️
🌟 Erzmagier Mensch [630.34] ⚔️ Untoter [1.00] -> Schaden: 280.00
   🌟 Erzmagier Mensch [630.34], Untoter ☠☠☠
Mensch [122.72] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [122.72], Untoter [64.00]
Mensch [140.00] ⚔️ Untoter [64.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [8.00]
Mensch [53.60] ⚔️ Untoter [64.00] -> Schaden: 56.00
   Mensch [53.60], Untoter [8.00]
Mensch [41.31] ⚔️ Untoter [120.00] -> Schaden: 56.00
   Mensch [41.31], Untoter [64.00]
Mensch [122.72] ⚔️ Untoter [64.00] -> Schaden: 56.00
   Mensch [122.72], Untoter [8.00]
Mensch [83.52] ⚔️ Ork [100.00] -> Schaden: 56.00
   Mensch [83.52], Ork [44.00]
Mensch [140.00] ⚔️ Untoter [64.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [8.00]
🌟 Daemonslayer Nachtelf [334.40] ⚔️ Untoter [8.00] -> Schaden: 94.50
   🌟 Daemonslayer Nachtelf [334.40], Untoter ☠☠☠
Nachtelf [17.60] ⚔️ Untoter [8.00] -> Schaden: 31.50
   Nachtelf [17.60], Untoter ☠☠☠
Nachtelf [42.40] ⚔️ Untoter [64.00] -> Schaden: 31.50
   Nachtelf [42.40], Untoter [32.50]
Nachtelf [67.20] ⚔️ Ork [100.00] -> Schaden: 31.50
   Nachtelf [67.20], Ork [68.50]
Nachtelf [68.80] ⚔️ Untoter [64.00] -> Schaden: 31.50
   Nachtelf [68.80], Untoter [32.50]
Untoter [57.00] ⚔️ Mensch [140.00] -> Schaden: 17.28
   Untoter [57.00], Mensch [122.72]
Untoter [32.50] ⚔️ Mensch [41.31] -> Schaden: 17.28
   Untoter [32.50], Mensch [24.03]
Untoter [32.50] ⚔️ Nachtelf [67.20] -> Schaden: 25.60
   Untoter [32.50], Nachtelf [41.60]
Untoter [8.00] ⚔️ Mensch [24.03] -> Schaden: 17.28
   Untoter [8.00], Mensch [6.75]
Untoter [88.50] ⚔️ Nachtelf [42.40] -> Schaden: 25.60
   Untoter [88.50], Nachtelf [16.80]
Untoter [32.50] ⚔️ Nachtelf [16.80] -> Schaden: 25.60
   Untoter [32.50], Nachtelf ☠☠☠
Untoter [8.00] ⚔️ 🌟 Erzmagier Mensch [630.34] -> Schaden: 17.28
   Untoter [8.00], 🌟 Erzmagier Mensch [613.06]
Ork [68.50] ⚔️ Nachtelf [17.60] -> Schaden: 26.40
   Ork [68.50], Nachtelf ☠☠☠
Ork [44.00] ⚔️ Nachtelf [68.80] -> Schaden: 26.40
   Ork [44.00], Nachtelf [42.40]
⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️


---------RUNDE 4-------
Squad von: The walking dead
  Squadgröße: 9
    Untoter [57.00]
    Untoter [32.50]
    Untoter [32.50]
    Untoter [8.00]
    Untoter [88.50]
    Untoter [32.50]
    Untoter [8.00]
    Ork [68.50]
    Ork [44.00]

Squad von: Legolas and friends
  Squadgröße: 11
    🌟 Erzmagier Mensch [613.06]
    Mensch [122.72]
    Mensch [122.72]
    Mensch [53.60]
    Mensch [6.75]
    Mensch [122.72]
    Mensch [83.52]
    Mensch [140.00]
    🌟 Daemonslayer Nachtelf [334.40]
    Nachtelf [41.60]
    Nachtelf [42.40]

⚔️⚔️⚔️⚔️⚔️⚔️⚔️ Kampf ⚔️⚔️⚔️⚔️⚔️⚔️⚔️
🌟 Erzmagier Mensch [613.06] ⚔️ Ork [68.50] -> Schaden: 280.00
   🌟 Erzmagier Mensch [613.06], Ork ☠☠☠
Mensch [122.72] ⚔️ Untoter [32.50] -> Schaden: 56.00
   Mensch [122.72], Untoter ☠☠☠
Mensch [122.72] ⚔️ Ork [44.00] -> Schaden: 56.00
   Mensch [122.72], Ork ☠☠☠
Mensch [53.60] ⚔️ Untoter [32.50] -> Schaden: 56.00
   Mensch [53.60], Untoter ☠☠☠
Mensch [6.75] ⚔️ Untoter [8.00] -> Schaden: 56.00
   Mensch [6.75], Untoter ☠☠☠
Mensch [122.72] ⚔️ Untoter [88.50] -> Schaden: 56.00
   Mensch [122.72], Untoter [32.50]
Mensch [83.52] ⚔️ Untoter [8.00] -> Schaden: 56.00
   Mensch [83.52], Untoter ☠☠☠
Mensch [140.00] ⚔️ Untoter [57.00] -> Schaden: 56.00
   Mensch [140.00], Untoter [1.00]
🌟 Daemonslayer Nachtelf [334.40] ⚔️ Untoter [32.50] -> Schaden: 94.50
   🌟 Daemonslayer Nachtelf [334.40], Untoter ☠☠☠
Nachtelf [41.60] ⚔️ Untoter [1.00] -> Schaden: 31.50
   Nachtelf [41.60], Untoter ☠☠☠
Nachtelf [42.40] ⚔️ Untoter [32.50] -> Schaden: 31.50
   Nachtelf [42.40], Untoter [1.00]
Untoter [1.00] ⚔️ Mensch [140.00] -> Schaden: 17.28
   Untoter [1.00], Mensch [122.72]
⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️


---------RUNDE 5-------
Squad von: The walking dead
  Squadgröße: 1
    Untoter [1.00]

Squad von: Legolas and friends
  Squadgröße: 11
    🌟 Erzmagier Mensch [613.06]
    Mensch [122.72]
    Mensch [122.72]
    Mensch [53.60]
    Mensch [6.75]
    Mensch [122.72]
    Mensch [83.52]
    Mensch [122.72]
    🌟 Daemonslayer Nachtelf [334.40]
    Nachtelf [41.60]
    Nachtelf [42.40]

⚔️⚔️⚔️⚔️⚔️⚔️⚔️ Kampf ⚔️⚔️⚔️⚔️⚔️⚔️⚔️
🌟 Erzmagier Mensch [613.06] ⚔️ Untoter [1.00] -> Schaden: 280.00
   🌟 Erzmagier Mensch [613.06], Untoter ☠☠☠
⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️
---------SPIEL BEENDET-------
Sieger: Legolas and friends
```


## Abgabe

Alle Abgaben für die Vorlesung erfolgen über `git`.

Hierzu gehen Sie wie folgt vor:

  1. Öffnen Sie eine Kommandozeile (Terminal).
  2. Gehen Sie in Ihr Working Directory.
  3. Rufen Sie mit `bin/submit.sh` das Skript auf, das die Lösungen testet und kompiliert. Wenn Maven eine Fehlermeldung zeigt, beheben Sie diese zuerst, bevor Sie mit dem nächsten Schritt fortfahren.
  4. Wenn Sie Meldung "✅ Projekt gebaut" bekommen, checken Sie Ihre Änderungen in `git` **auf der Kommandozeile** ein (comitten), d.h. mit `git add` und `git commit`. Verwenden Sie **nicht** Eclipse für diesen Schritt.
  5. Rufen Sie mit `bin/submit.sh` erneut das Skript auf. Wenn alles klappt, bekommen Sie die Anzeige "✅ Aktuelle Lösungen eingereicht" und Ihre Lösung ist im System angekommen.
