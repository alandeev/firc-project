# Challenge - ADS - FICR
> 

### Group
```
1. Alan
2. Henrique
3. Bruno
4. Raiza
5. Kelner
```

# Documentation

## How to install?
> 1. git clone https://github.com/alandev2/firc-project.git
> 2. implements database using query's in mysql.sql
> 3. execute the project
> 4. test :D 


## **Routers**
### Employees

**LIST**
> [ GET ] http://localhost:8080/employees

**GET**
> [ GET ] http://localhost:8080/employees/{employee_id}

**DELETE**
> [ DELETE ] http://localhost:8080/employees/{employee_id}

**CREATE**
> [ POST ] http://localhost:8080/employees
```json
{
	"matricula": "",
	"nome": "",
	"sexo": "",
	"trainingId": 0
}
```

**UPDATE**
> [ PUT ] http://localhost:8080/employees/{employee_id}
```json
  {
    "matricula": "",
    "nome": "",
    "sexo": "",
    "trainingId": 0
  }
```

___
### Training

**LIST**
> [ GET ] http://localhost:8080/trainings

**GET**
> [ GET ] http://localhost:8080/trainings/{training_id}

**DELETE**
> [ DELETE ] http://localhost:8080/trainings/{training_id}

**CREATE**
> [ POST ] http://localhost:8080/trainings
```json
{
	"codigo": 1,
	"descricao": "Confeiteiro",
	"inicio": "2021-12-08T10:51:08.312Z",
	"termino": "2021-12-10T10:51:08.312Z",
	"cargaHoraria": 6,
	"vagas": 20
}
```

**UPDATE**
> [ PUT ] http://localhost:8080/trainings/{training_id}
```json
{
	"codigo": 1,
	"descricao": "Confeiteiro",
	"inicio": "2021-12-08T10:51:08.312Z",
	"termino": "2021-12-10T10:51:08.312Z",
	"cargaHoraria": 6,
	"vagas": 20
}
```

