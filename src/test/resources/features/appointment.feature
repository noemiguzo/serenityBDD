Feature: Funcionalidad make appointment
  Rule: Yo como usuario quiero realizar un appointment
  de manera exitosa y con todos los datos correctamente

    Background: Ingresar a Make appointment web
      Given el usuario ingresar a make appointment page
      And login to make appointment
    @regression-success

    Scenario Outline: Validar que make appointment fue exitosa
      When ingresar appoinment datos <facility>, <readmission>, <program>, <visitDate> y <comment>
      Then varificar appointment datos <facility>, <readmission>, <program>, <visitDate> y <comment>
      Examples:
        | facility                        | readmission | program  | visitDate  | comment |
        | Tokyo CURA Healthcare Center    | No          | Medicaid | 27/01/2023 | test1   |
        | Hongkong CURA Healthcare Center | No          | Medicare | 17/01/2023 | test2   |
        | Seoul CURA Healthcare Center    | True        | None     | 12/01/2023 | test3   |