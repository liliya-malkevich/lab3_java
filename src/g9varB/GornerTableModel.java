package g9varB;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private double result[] = new double[3];

    //Конструктора для инициализации полей
    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients)	{
        this.coefficients = coefficients;
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }
    //Количество строк в таблице зависит от длины интервала табулирования
    //и размера шага, поэтому его необходимо вычислять
    public int getRowCount() {
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }

    public Object getValueAt(int row, int col) 	{
        // Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step*row;
        double tempResult = 0.0;
        switch (col){
            case 0://первая колонка
                return x;
            case 1:// вторая колонка
            {
                result[0] = 0.0;
                for(int i = 0; i < coefficients.length; i++){
                    result[0] += Math.pow(x, coefficients.length-1-i)*coefficients[i];
                }
                tempResult = result[0];
                return result[0];
            }
            default:// третья колонка
            {
                result[0] = 0.0;
                for(int i = 0; i < coefficients.length; i++){
                    result[0] += Math.pow(x, coefficients.length-1-i)*coefficients[i];
                }
                System.out.println(result[0]);
                String str = Double.toString(result[0]);
                char num1 = str.charAt(0);
                for(int i1 = 1;i1<str.length();i1++){
                    if(str.charAt(i1) == '.') continue;
                    if(str.charAt(i1)==num1){
                        return true;
                    } else {
                        num1=str.charAt(i1);
                    }}
return false;
//                int p =0;
//                int temp1 = 0;
//                temp1 = (int)(result[0]*10000);System.out.println(temp1);
//                System.out.println(" ");
//
//                int temp2 = 1;
//                int temp3 = 1;
//
//                temp2 = temp1/10000;System.out.println(temp2);
//                temp3 = (temp1/1000)%10;System.out.println(temp3);
//                if(temp2 == temp3) return true;System.out.println(" ");
//
//                temp2 = temp3;System.out.println(temp2);
//                temp3 = (temp1/100)%10;System.out.println(temp3);
//                if(temp2 == temp3) return true;System.out.println(" ");
//
//                temp2 = temp3;
//                temp3 = (temp1/10)%10;
//                if(temp2 == temp3) return true;
//
//                temp2 = temp3;
//                temp3 = (temp1)%10;
//                if(temp2 == temp3) return true;
//                return false;
//
//
//


            }



        }
    }

    //Тип данных для обоих столбцов в нашем случае одинаков, им является
    // число  с  плавающей  точкой  –  Double.
    public Class<?> getColumnClass(int col) {

        switch (col) {
            case 0:
                return Double.class;
            case 1:
                return Double.class;
            default:
                return Boolean.class;
        }
    }



    //Cведения о названиях столбцов
    public String getColumnName(int col) {

        switch (col){
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "Две пары";
        }
    }

}

