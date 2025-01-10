# Harry Potter: La Batalla de Hogwarts-OO

> *"Oscuros y difíciles tiempos nos aguardan. Pronto todos tendremos que decidir entre lo que es correcto y lo que es fácil."* — Albus Dumbledore

En el mundo mágico, las fuerzas oscuras han comenzado a ganar terreno. Después de la caída del Ministerio de Magia, los mortífagos han tomado control de gran parte del mundo mágico, dejando a Hogwarts como uno de los últimos bastiones de la resistencia. Voldemort ha desatado un ejército de inferi que amenazan con destruir todo a su paso.

## Misión: Sistema de Defensa Mágica

Para proteger el castillo y derrotar a las fuerzas oscuras, se requiere desarrollar un sistema de defensa mágica que simule un campo de batalla. A continuación, se detallan las especificaciones del sistema:

### 1. Tamaño de la cuadrícula
- El número de columnas y filas debe ser mayor que 5 y menor que 10.
- Debe definirse al inicio de la simulación.

### 2. Distribución de enemigos mágicos
- Se posicionarán aleatoriamente un número de enemigos mágicos en la cuadrícula:
  - **Inferi tipo I**: 40% de los enemigos, con un nivel de energía de 50 puntos.
  - **Inferi tipo II**: 30% de los enemigos, con un escudo mágico de hasta 100 puntos.
  - **Mortífagos avanzados**: 30% de los enemigos, con un escudo de energía entre 100 y 150 puntos (determinado aleatoriamente).
- El número total de enemigos debe ser mayor que 15 y menor que 25.

### 3. Sistema de escaneo y defensa
- La cuadrícula escaneará aleatoriamente buscando enemigos.
- **Hechizo básico ("Stupefy")**: Daña al enemigo en 25 puntos de energía.
- **Hechizo crítico ("Expulso")**: Un 20% de las veces, realiza un daño de 50 puntos.
- Si un enemigo es destruido (su energía llega a 0), desaparece del campo.

### 4. Movimiento de los enemigos
- Cada 500 milisegundos, los enemigos se moverán a una nueva posición aleatoria, desplazando cualquier enemigo de esa posición a otro lugar libre.

### 5. Finalización del sistema
El programa termina cuando:
- Todos los enemigos han sido derrotados.
- Ha transcurrido un tiempo máximo de 15 segundos (definido al inicio).

### Informe final
Al finalizar el sistema, se generará un informe con los siguientes datos:
- Número inicial de enemigos mágicos.
- Número de enemigos restantes.
- Número total de hechizos lanzados.
- Número de enemigos destruidos.
- Porcentaje de precisión en los hechizos.
- Lista de los enemigos restantes, ordenados por energía de mayor a menor.

## Ejecución del sistema
El sistema debe ejecutarse desde la línea de comandos de la siguiente manera:

```
java -jar defensaHogwarts.jar <num_columnas> <num_filas> <num_enemigos>
```

Si los parámetros no son correctos o no se ingresan, el programa no puede ejecutarse hasta que se introduzcan los parametros correctos.

> *"Solo aquellos con la valentía de enfrentarse al desafío podrán salir victoriosos."* — Minerva McGonagall


