package model;

import utils.MatrixManager;

import java.util.Random;

public class Car extends Thread{

    private int row;
    private int column;
    private int speed;

    private Cell cell;
    private Cell nextCell;

    public Car(){
        setSpeed();
    }

    @Override
    public void run() {
        super.run();
        if (checkLastCell()){
            System.out.println("ultima celula");
        }else {
//            while (checkLastCell() || checkStopCell()){
                movimenta();

//            }
        }
    }

    private boolean checkLastCell() {
        return false;
    }

//    private boolean checkStopCell(){ //cruzamento
//       return false
//    }

    private void movimenta() {
        int moveType = MatrixManager.getInstance().getValueAtPosition(this.getRow(), this.getColumn());
        switch(moveType){
            case 1:
                System.out.println("andou cima");
                this.setRow(this.getRow()-1);
                this.setColumn(this.getColumn());
                break;
            case 2:
                System.out.println("andou dir");
                this.setRow(this.getRow());
                this.setColumn(this.getColumn()+1);
                break;
            case 3:
                System.out.println("andou baixo");
                this.setRow(this.getRow()+1);
                this.setColumn(this.getColumn());
                break;
            case 4:
                System.out.println("andou esq");
                this.setRow(this.getRow());
                this.setColumn(this.getColumn()-1);
                break;
            default:
                break;
        }

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setSpeed(){
        Random random = new Random();
        this.speed = random.nextInt((100) + 1) + 10;
    }

    public int getSpeed(){ //timesleep para a thread
        return speed;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean setFirstPosition(Integer row, Integer col) {
        Cell cell = MatrixManager.getInstance().getCellAtPosition(row, col);
        if(cell.containsCar()){
            System.out.println("Vaga ocupada");
           return false;

        }else{
            cell.setContainsCar(true);
            setRow(row);
            setColumn(col);
            System.out.println("inserido em:"+row+","+col);
            return true;
        }
    }
}
