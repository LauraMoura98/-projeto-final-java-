package com.projeto.classes;


public class Garcom {
    private int id_garcom;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String sexo;
    private float salarioFixo;

    public float getMediaSalario() {
        return mediaSalario;
    }

    public void setMediaSalario(float mediaSalario) {
        this.mediaSalario = mediaSalario;
    }

    private float mediaSalario;

    public Garcom(float mediaSalario) {};

    public Garcom(int id_garcom, String nome, String cpf, String dataNascimento, String email, String telefone, String sexo,
                  float salarioFixo) {
        super();
        this.id_garcom = id_garcom;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.salarioFixo = salarioFixo;
    }
    public int getId_garcom() {
        return id_garcom;
    }
    public void setId_garcom(int id_garcom) {
        this.id_garcom = id_garcom;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public float getSalarioFixo() {
        return salarioFixo;
    }
    public void setSalarioFixo(float salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

}
