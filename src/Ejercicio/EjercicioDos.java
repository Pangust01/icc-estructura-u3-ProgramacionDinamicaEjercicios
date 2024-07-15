package Ejercicio;

import java.util.ArrayList;
import java.util.List;

/*
 * Dados n pares de paréntesis, implementa un algoritmo para generar todas las combinaciones
 * válidas de paréntesis.
 *
 * Ejemplo 1:
 *  Input:
 *    n: 1
 *  Output:
 *    ["()"]
 *
 * Ejemplo 2:
 *  Input:
 *    n: 3
 *  Output:
 *    ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 * Se debe usar StringBuilder
 */
public class EjercicioDos {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(current.toString());
            return;
        }

        if (left > 0) {
            current.append('(');
            backtrack(result, current, left - 1, right);
            current.deleteCharAt(current.length() - 1);
        }

        if (right > left) {
            current.append(')');
            backtrack(result, current, left, right - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
