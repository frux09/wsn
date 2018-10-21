# wsn

Aplicación que simula una WSN. Para ello contamos con tres clases:
  
  -Sensor: Representa al tipo de sensor que tomará datos, por ejemplo: ultrasonido, temperatura, humedad...
  
  -Node: Representa al nodo de la WSN, por lo que estará formado por el sensor y el tipo de placa correspondiente.
  
  -Data: Representa a los datos que recogen los nodos sensores, por lo que está formado por el valor correspondiente, el nodo que toma el dato y la fecha.
  
  
Desde el punto de vista de usabilidad de la aplicación, contamos con la siguiente API REST:

  -Para los sensores tenemos la ruta /sensor con metodos POST y GET(/sensor/{idSensor}), para crear un sensor y para obtenerlos respectivamente.
  
  -Para los nodos tenemos la ruta /sensor/{idSensor}/node con metodos POST y GET(/sensor/{idSensor}/node/{idNode}) para crearlos y obtenerlos.
  
  -Finalmente, para los datos tenemos la ruta /node/{idNode}/data con el CRUD completo:
  
      -Para obtener datos tenemos varias formas:
        -Con /node/{idNode}/data/{idData} obtenemos la info especifica de un dato del nodo idNode.
        -Con /node/{idNode}/data obtenemos todos los datos del nodo idNode.
        -Con /node/{idNode}/data/query/{value} obtenemos un listado de los datos ofrecidos por el nodo idNode que sean mayores al parámetro value y ordenados descendientemente por idNode.
