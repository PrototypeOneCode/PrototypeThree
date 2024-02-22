/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguide.customermanagement.model;



/**
 *
 * @author End User
 */
public class Customer {
    private int id;
    private String name;
    private String address;
    private String date;
    private int invoiceNo;
    private String description;
    private double invoiceTotal;

    /**
     *
     * @param id
     * @param name
     * @param address
     * @param date
     * @param invoiceNo
     * @param description
     * @param invoiceTotal
     */
    public Customer(int id, String name, String address, String date, int invoiceNo, String description, double invoiceTotal) {
        //super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.invoiceNo = invoiceNo;
        this.description = description;
        this.invoiceTotal = invoiceTotal; 
    }
    
    public Customer(String name, String address, String date, int invoiceNo, String description, double invoiceTotal) {
        super();
        this.name = name;
        this.address = address;
        this.date = date;
        this.invoiceNo = invoiceNo;
        this.description = description;
        this.invoiceTotal = invoiceTotal; 
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the invoiveNo
     */
    public int getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo the invoiveNo to set
     */
    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the invoiceTotal
     */
    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    /**
     * @param invoiceTotal the invoiceTotal to set
     */
    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }
    
}
