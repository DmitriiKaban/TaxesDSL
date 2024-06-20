package org.pbl.util;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {

//    public static String tvaPhysic = "";
    public static String tvaJuridic = "";
    public static String medicalInsurancePhysic = "";
//    public static String medicalInsuranceJuridic = "";
    public static String amenajareaTeritoriuluiJuridic = "";
//    public static String amenajareaTeritoriuluiJuridic = "";
//    public static String impozitProfitPhysic = "";
//    public static String impozitProfitJuridic = "";
    public static String impozitImobiliarPhysic = "";
    public static String impozitImobiliarJuridic = "";
    public static String impozitFunciarPhysic = "";
    public static String impozitFunciarJuridic = "";
    public static String impozitulPeVenitPhysic = "";
    public static String impozitulPeVenitJuridic = "";

    public static int loadValuesFromFile() {
        Ini ini;
        File tempFile = new File("config/config.ini");
        if (tempFile.exists()) {

            System.out.println("Trying to read file: " + tempFile.getAbsolutePath());
            try {
                ini = new Ini(tempFile);
                extractDataFromIni(ini);
            } catch (IOException e) {
                System.out.println("Error reading file: " + tempFile.getAbsolutePath());
                return 0;
            }
        }else {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            tempFile = new File(s + "\\config.ini");

            System.out.println("Trying to read file: " + tempFile.getAbsolutePath());
            try {
                ini = new Ini(tempFile);
                extractDataFromIni(ini);
            } catch (IOException ex) {
                System.out.println("Error reading file: " + tempFile.getAbsolutePath());
                return 0;
            }
        }
        return 1;
    }

    private static void extractDataFromIni(Ini ini) {

//        tvaPhys = getOrDefault(ini, "taxes_values_physic", "tva", "-1");
        tvaJuridic = getOrDefault(ini, "taxes_values_juridic", "tva", "-1");
        medicalInsurancePhysic = getOrDefault(ini, "taxes_values_physic", "medicalInsurance", "-1");
//        medicalInsuranceJuridic = getOrDefault(ini, "taxes_values_juridic", "medicalInsurance", "-1");
        amenajareaTeritoriuluiJuridic = getOrDefault(ini, "taxes_values_juridic", "amenajareaTeritoriului", "-1");
//        amenajareaTeritoriuluiJuridic = getOrDefault(ini, "taxes_values_juridic", "amenajareaTeritoriuluiJuridic", "-1");
//        impozitProfitPhysic = getOrDefault(ini, "taxes_values_physic", "impozitProfitPhysic", "-1");
//        impozitProfitJuridic = getOrDefault(ini, "taxes_values_juridic", "impozitProfitJuridic", "-1");
        impozitImobiliarPhysic = getOrDefault(ini, "taxes_values_physic", "impozitImobiliar", "-1");
        impozitImobiliarJuridic = getOrDefault(ini, "taxes_values_juridic", "impozitImobiliar", "-1");
        impozitFunciarPhysic = getOrDefault(ini, "taxes_values_physic", "impozitFunciar", "-1");
        impozitFunciarJuridic = getOrDefault(ini, "taxes_values_juridic", "impozitFunciar", "-1");
//        tvaRealizarePhysic = getOrDefault(ini, "taxes_values_physic", "tvaRealizarePhysic", "-1");
//        tvaRealizareJuridic = getOrDefault(ini, "taxes_values_juridic", "tvaRealizareJuridic", "-1");
        impozitulPeVenitPhysic = getOrDefault(ini, "taxes_values_physic", "impozitulPeVenit", "-1");
        impozitulPeVenitJuridic = getOrDefault(ini, "taxes_values_juridic", "impozitulPeVenit", "-1");

//        System.out.println(impozitFunciarJuridic);
    }

    private static String getOrDefault(Ini ini, String section, String key, String defaultValue) {
        String value = ini.get(section, key);
        return value != null ? value : defaultValue;
    }

}