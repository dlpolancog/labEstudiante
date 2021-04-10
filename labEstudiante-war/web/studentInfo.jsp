<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario llenado de datos</title>
    </head>
    <body>
        <h1>Información del estudiante</h1>
        <form action="./StudentInfo" method="POST">
            <table>
                <tr>
                    <td>Identificación del estudiante</td>
                    <td><input type="text" name="idEstudiante" value="${estudiante.idEstudiante}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${estudiante.nombre}" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="${estudiante.apellido}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${estudiante.semestre}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Agregar" />
                        <input type="submit" name="action" value="Editar" />
                        <input type="submit" name="action" value="Eliminar" />
                        <input type="submit" name="action" value="Buscar" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Identificación</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Semestre</th>
                <c:forEach items="${allStudent}" var="stud">
                <tr>
                    <td>${stud.idEstudiante}</td>
                    <td>${stud.nombre}</td>
                    <td>${stud.apellido}</td>
                    <td>${stud.semestre}</td>
                </tr>
            </c:forEach> 
        </table>
        
        <h1>Información del curso</h1>
        <form action="./CursoInfo" method="POST">
            <table>
                <tr>
                    <td>Código del curso</td>
                    <td><input type="text" name="codigoCurso" value="${curso.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre del curso</td>
                    <td><input type="text" name="nombreCurso" value="${curso.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td>Número de creditos</td>
                    <td><input type="text" name="numeroCreditos" value="${curso.numeroCreditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                <tr>
                    <td>Estudiantes Admitidos</td>
                    <td><input type="text" name="estudiantesAdmitidos" value="${curso.estudiantesAdmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Agregar" />
                        <input type="submit" name="action" value="Buscar" />
                    </td>
                </tr>
            </table>
        </form>
        
        <table border="1">
            <th>Código</th>
            <th>Nombre</th>
            <th>Créditos</th>
            <th>Semestre</th>
            <th>EstudiantesAdmitidos</th>
                <c:forEach items="${allCurso}" var="cur">
                <tr>
                    <td>${cur.codigoCurso}</td>
                    <td>${cur.nombreCurso}</td>
                    <td>${cur.numeroCreditos}</td>
                    <td>${cur.semestre}</td>
                    <td>${cur.estudiantesAdmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>     
        
        <h1>Añadir estudiante a un curso</h1>
        <form action="./EstudianteCursoInfo" method="POST">
            <table>
                <tr>
                    <td>Código del curso</td>
                    <td><input type="text" name="codigoCurso" value="${estudianteCurso.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Identificación del estudiante</td>
                    <td><input type="text" name="idEstudiante" value="${estudianteCurso.idEstudiante}" /></td>
                </tr>
                <tr>
                    <td>Nota</td>
                    <td><input type="text" name="nota" value="${estudianteCurso.nota}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Agregar" />
                    </td>
                </tr>
            </table>
        </form> 
         
    </body>
</html>