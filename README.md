# Hundir la flota (Battleship) en Java

Juego de hundir la flota por consola, escrito en Java **sin funciones**: toda la lógica vive en un único método `main`, solo con variables, bucles, condicionales y arrays.

- Dos modos de juego: **básico** y **avanzado**.
- Colocación aleatoria de los barcos con `Math.random()`.
- En modo avanzado eliges el tamaño del tablero (de 5×5 a 10×10) y los símbolos del agua, los fallos, los barcos tocados y los hundidos.
- Opción de jugar varias partidas seguidas.

Los disparos se escriben con el formato `(fila, columna)`, por ejemplo `(2, B)`.

## Ejecutar

```bash
javac src/BattleShip.java -d out
java -cp out BattleShip
```
