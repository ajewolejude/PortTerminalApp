package com.terminal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Home {
    private JPanel mainPanel;
    private JTextField destination;
    private JTextField count;
    private JPanel port;
    private JTextField cell00;
    private JTextField cell03;
    private JTextField cell11;
    private JTextField cell12;
    private JTextField cell13;
    private JTextField cell23;
    private JTextField cell22;
    private JTextField cell21;
    private JTextField cell20;
    private JTextField cell01;
    private JTextField cell02;
    private JTextField cell10;
    private JTextField cell30;
    private JTextField cell32;
    private JTextField cell33;
    private JTextField cell31;
    private JButton drop;
    private JLabel Jlabel2;


    public Home() {

        Utils utils = new Utils();

        drop.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {


                //storage of cells
                String cellString00, cellString01, cellString02, cellString03;
                String cellString10, cellString11, cellString12, cellString13;
                String cellString20, cellString21, cellString22, cellString23;
                String cellString30, cellString31, cellString32, cellString33;
                String destinationValue, countValue;


                countValue = count.getText();
                destinationValue = destination.getText();
                for (int iC = 0; iC < Integer.parseInt(countValue); iC++) {



                    long[][] acceptancePercentage = new long[4][4];


                    //get content of all cells in first row.
                    Region regionZero = new Region();
                    regionZero.setName("0");
                    Cell cell_00 = new Cell(cell00.getText(), "00");
                    Cell cell_01 = new Cell(cell01.getText(), "01");
                    Cell cell_02 = new Cell(cell02.getText(), "02");
                    Cell cell_03 = new Cell(cell03.getText(), "03");
                    ArrayList<Cell> cellsZero = new ArrayList<>();
                    cellsZero.add(cell_00);
                    cellsZero.add(cell_01);
                    cellsZero.add(cell_02);
                    cellsZero.add(cell_03);
                    regionZero.setCells(cellsZero);


                    Region regionOne = new Region();
                    regionOne.setName("1");
                    Cell cell_10 = new Cell(cell10.getText(), "10");
                    Cell cell_11 = new Cell(cell11.getText(), "11");
                    Cell cell_12 = new Cell(cell12.getText(), "12");
                    Cell cell_13 = new Cell(cell13.getText(), "13");
                    ArrayList<Cell> cellsOne = new ArrayList<>();
                    cellsOne.add(cell_10);
                    cellsOne.add(cell_11);
                    cellsOne.add(cell_12);
                    cellsOne.add(cell_13);
                    regionOne.setCells(cellsOne);


                    Region regionTwo = new Region();
                    regionTwo.setName("2");
                    Cell cell_20 = new Cell(cell20.getText(), "20");
                    Cell cell_21 = new Cell(cell21.getText(), "21");
                    Cell cell_22 = new Cell(cell22.getText(), "22");
                    Cell cell_23 = new Cell(cell23.getText(), "23");
                    ArrayList<Cell> cellsTwo = new ArrayList<>();
                    cellsTwo.add(cell_20);
                    cellsTwo.add(cell_21);
                    cellsTwo.add(cell_22);
                    cellsTwo.add(cell_23);
                    regionTwo.setCells(cellsTwo);


                    Region regionThree = new Region();
                    regionTwo.setName("3");
                    Cell cell_30 = new Cell(cell30.getText(), "30");
                    Cell cell_31 = new Cell(cell31.getText(), "31");
                    Cell cell_32 = new Cell(cell32.getText(), "33");
                    Cell cell_33 = new Cell(cell33.getText(), "33");
                    ArrayList<Cell> cellsThree = new ArrayList<>();
                    cellsThree.add(cell_30);
                    cellsThree.add(cell_31);
                    cellsThree.add(cell_32);
                    cellsThree.add(cell_33);
                    regionThree.setCells(cellsThree);

                    List<Region> regionList = new ArrayList<>();
                    regionList.add(regionZero);
                    regionList.add(regionOne);
                    regionList.add(regionTwo);
                    regionList.add(regionThree);
//
//                ArrayList<Region> regionArrayList =  spaceList.get(0);
//                ArrayList<String> spaceRowOneList =  spaceList.get(1);
//                ArrayList<String> spaceRowTwoList =  spaceList.get(2);
//                ArrayList<String> spaceRowThreeList =  spaceList.get(3);
//                spaceRowZeroList.add(cell00.getText());
//                spaceRowZeroList.add(cell01.getText());
//                spaceRowZeroList.add(cell02.getText());
//                spaceRowZeroList.add(cell03.getText());
//                spaceRowOneList.add(cell10.getText());
//                spaceRowOneList.add(cell11.getText());
//                spaceRowOneList.add(cell12.getText());
//                spaceRowOneList.add(cell13.getText());
//                spaceRowTwoList.add(cell20.getText());
//                spaceRowTwoList.add(cell21.getText());
//                spaceRowTwoList.add(cell22.getText());
//                spaceRowTwoList.add(cell23.getText());
//                spaceRowThreeList.add(cell30.getText());
//                spaceRowThreeList.add(cell31.getText());
//                spaceRowThreeList.add(cell32.getText());
//                spaceRowThreeList.add(cell33.getText());


                    //all acceptance percentage is 100 at the beginning
                    for (int i = 0; i < acceptancePercentage.length; ++i) {
                        for (int j = 0; j < acceptancePercentage[i].length; ++j) {
                            acceptancePercentage[i][j] = 0;

                        }
                    }


                    // first one is that if it is full (stack size is equal to 5)


                    for (int i = 0; i < regionList.size(); i++) {
                        Region singleRegion = regionList.get(i);


                        for (int j = 0; j < regionList.size(); j++) {
                            Cell cell = singleRegion.getCells().get(j);
                            String[] container = cell.getContainers().split(" ");

                            //when it is full
                            if (container.length == 6) {
                                acceptancePercentage[i][j] = -20;
                            }else if (container.length < 6){
                                //get how many of similar destination - reduce percentage based one the destination similarities
                                long count = utils.countOccurences(cell.getContainers(), destinationValue.charAt(0));
                                acceptancePercentage[i][j] = 100 - ((20) * (5 - count));
                                long here = acceptancePercentage[i][j];
                                System.out.println(here);
                            }



                        }

                    }

                    String bestPositionToStore = utils.getIndexOfLargest(acceptancePercentage);


                    //deciding which UI to update

                    if (Objects.equals(bestPositionToStore, "0,0")) {
                        cell00.setText(regionList.get(0).getCells().get(0).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "0,1")) {
                        cell01.setText(regionList.get(0).getCells().get(1).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "0,2")) {
                        cell02.setText(regionList.get(0).getCells().get(2).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "0,3")) {
                        cell03.setText(regionList.get(0).getCells().get(3).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "1,0")) {
                        cell10.setText(regionList.get(1).getCells().get(0).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "1,1")) {
                        cell11.setText(regionList.get(1).getCells().get(1).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "1,2")) {
                        cell12.setText(regionList.get(1).getCells().get(2).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "1,3")) {
                        cell13.setText(regionList.get(1).getCells().get(3).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "2,0")) {
                        cell20.setText(regionList.get(2).getCells().get(0).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "2,1")) {
                        cell21.setText(regionList.get(2).getCells().get(1).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "2,2")) {
                        cell22.setText(regionList.get(2).getCells().get(2).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "2,3")) {
                        cell23.setText(regionList.get(2).getCells().get(3).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "3,0")) {
                        cell30.setText(regionList.get(3).getCells().get(0).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "3,1")) {
                        cell31.setText(regionList.get(3).getCells().get(1).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "3,2")) {
                        cell32.setText(regionList.get(3).getCells().get(2).getContainers() + " " + destinationValue.charAt(0));
                    } else if (Objects.equals(bestPositionToStore, "3,3")) {
                        cell33.setText(regionList.get(3).getCells().get(3).getContainers() + " " + destinationValue.charAt(0));
                    }



                }

                //store stack size
                int stackSize = 5;

                ArrayList<ArrayList<String>> spaceList = new ArrayList<ArrayList<String>>();

                //String message = "Added " + destinationValue.charAt(0) + " to " + bestPositionToStore;
              //  JOptionPane.showMessageDialog(null, message);
            }
        });


    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Home");
        jFrame.setContentPane(new Home().mainPanel);
        jFrame.setTitle("Port Terminal Problem");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);


    }


}
