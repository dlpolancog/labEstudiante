<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentInfo" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="idEstudiante" value="${student.idEstudiante}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="nombre" value="${student.nombre}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="apellido" value="${student.apellido}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="semestre" value="${student.semestre}" /></td>
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
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudent}" var="stud">
                <tr>
                    <td>${stud.idEstudiante}</td>
                    <td>${stud.nombre}</td>
                    <td>${stud.apellido}</td>
                    <td>${stud.semestre}</td>
                </tr>
            </c:forEach> 
        </table>

        <h1>Add student to class</h1>
        <form action="./EstudianteCursoInfo" method="POST">
            <table>
                <tr>
                    <td>Student id</td>
                    <td><input type="text" name="idEstudiante" value="${stuSub.idEstudiante}" /></td>
                </tr>
                <tr>
                    <td>Subject Id</td>
                    <td><input type="text" name="codigoCurso" value="${stuSub.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Grade</td>
                    <td><input type="text" name="nota" value="${stuSub.nota}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Agregar" />
                    </td>
                </tr>
            </table>
        </form> 
        <br>

        <h1>Información del curso</h1>
         <form action="./CursoInfo" method="POST">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombreCurso" value="${subInf.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" name="codigoCurso" value="${subInf.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="numeroCreditos" value="${subInf.numeroCreditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${subInf.semestre}" /></td>
                </tr>
                <tr>
                    <td>Estudiantes Admitidos</td>
                    <td><input type="text" name="estudiantesAdmitidos" value="${subInf.estudiantesAdmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Agregar" />
                        <input type="submit" name="action" value="buscar" />
                    </td>
                </tr>
            </table>
        </form> 
    </body>
</html>