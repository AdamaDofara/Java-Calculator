package expression;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import opérateurs.Operateurs;

public class AnalyseEquation implements Validator {
		
	//Pour valider la strcuture génrale de l'expression 
	
	public   void analyseExpression(String equation) throws ArithmeticException{
		int count=0;
		char[] chaine = equation.toCharArray();
		for (int i =0; i<chaine.length; i++) {
			if (chaine[i]=='(') {
				count++;
			} 
			else if (chaine[i]==')') {
				count--;
				if (i+1<=chaine.length-1) {
					//gestion du cas )(
					if (chaine[i+1]=='(') {
						throw new ArithmeticException();
					}
//					gestion du cas )1234
					else if (Character.isDigit(chaine[i+1])) {
						throw new ArithmeticException();
					}
				}
			}
			// gestion des operateurs qui se suivent ++
			else if(operateurAutorise(chaine[i]) && operateurAutorise(chaine[i+1])) {
				throw new ArithmeticException();
			}
			else if(operateurAutorise( chaine[chaine.length-1] )) {
				throw new ArithmeticException();
			}
			//Ni operateur ni chiffre
			else if(!operateurAutorise(chaine[i]) && 
					!Character.isDigit(chaine[i]) &&
					chaine[i]!='(' &&
					chaine[i]!=')' && chaine[i]!=' '
					) {
				throw new ArithmeticException();
			}
			//Gestion du cas ou on a "2   3  4"
			else if (Character.isDigit(chaine[i]) && i+1<=chaine.length-1) {
				if (chaine[i+1]==' ') {
					int j =i+1;
					while (chaine[j]==' ' && j<chaine.length) {
						j++;
					}
					if (Character.isDigit(chaine[j])){
						throw new ArithmeticException();
					}
				}
			}
		}
		if (count!=0) {
			throw new ArithmeticException("Equation pas bien parenthésée");
		}
	}
	
	public static List<Object> conversionEnNotationPolonnaise(String expression) {
		expression = expression.replaceAll(" ", "");
		Stack<Character> stack = new Stack<>();
        List<Object> output = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(expression.charAt(i))) {
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numStr.append(expression.charAt(i));
                    i++;
                    
                }
                i=i-1;
                output.add(Double.parseDouble(numStr.toString()));

            }
            else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.add(stack.pop().toString());
                }
                stack.pop(); // Discard '('
            }
            else {
                while (!stack.isEmpty() && operateurAutorise(stack.peek()) &&
                        priorite(stack.peek()) >= priorite(expression.charAt(i))) {
                		output.add(stack.pop().toString());
                }
                stack.push(c);
            }
        }
       
        while (!stack.isEmpty()) {
            output.add(stack.pop().toString());
        }
        return output;
		
		
	}
//Verifier qu'un caractere est booleen
	private static boolean operateurAutorise(char c) {
		if (c == '+' || c == '-' || c == '/' || c == '*') {
			return true;
		} else {
			return false;
		}
	}

	//Definition de la priorite des operateurs
	private static int priorite(char c) {
		switch (c) {
	    case '+':
	    case '-':
	        return 1;
	    case '*':
	    case '/':
	        return 2;
	    default:
	        return -1;
	}
	}
	public static double calculate (List<Object> list) {
		Stack<Double> stack = new Stack<>();
        for (Object obj : list) {
            if (obj instanceof Double) {
                stack.push((Double)obj);
            } else {
               String operator =  obj.toString();
               double operand2 = stack.pop();
               double result;
               if (stack.isEmpty()) {
               	 result = AppliquerOperation(operator, 0, operand2);
				}
               else {
               double operand1 = stack.pop();
                result = AppliquerOperation(operator, operand1, operand2);
               }
               stack.push(result);
            }
	}
        return stack.pop();
	}
	
	public static double AppliquerOperation(String operator, double operand1, double operand2) {
        switch(operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new ArithmeticException();
        }
    }
}
