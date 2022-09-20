public class TestHero{
   public static void main(String[] args){
      // Testing Hero Factory
      // Test createHero()
      HeroInterface failed = HeroFactory.createHero("INVALID", "WRONG");
      assert failed == null: "Created an invalid race and job";
      
      HeroInterface failed2 = HeroFactory.createHero("DWARF", "NOTJOB");
      assert failed2 == null: "Created an invalid job";
      
      HeroInterface failed3 = HeroFactory.createHero("NOTRACE", "WARRIOR");
      assert failed3 == null;
      
      //////////////////////////////////////////// Testing DWARF WARRIOR //////////////////////////////////////////////////////
      HeroInterface DW = HeroFactory.createHero("DWARF", "WARRIOR");
      assert DW != null: "DWARF WARRIOR did not create successfully";
      
      // STR, DEX, INT
      assert DW.getSTR() == 25:"DWARF WARRIOR returns incorrect STR " + DW.getSTR();
      assert DW.getDEX() == 20:"DWARF WARRIOR returns incorrect DEX " + DW.getDEX();
      assert DW.getINT() == 20:"DWARF WARRIOR returns incorrect INT " + DW.getINT();
      
      // attack
      // Warrior: STR * val + DEX
      //          25  * 10  + 20
      assert DW.attack(10) == 270: "Incorrect value produced from attack " + DW.attack(10) + ", should be 270";
      
      // Checking negative values
      //          25  * -1  + 20
      assert DW.attack(-1) == -5: "Incorrect value produced from attack " + DW.attack(-1) + ", should be -5";
      
      // Test race name
      assert DW.getRaceName().equals("DWARF"): "Race name not returned correctly: " + DW.getRaceName() + ", should be DWARF";
      
      // Test job name
      assert DW.getJobName().equals("WARRIOR"): "Job name not returned correctly: " + DW.getJobName() + ", should be WARRIOR";
      
      ///////////////////////////////////////////// Testing DWARF ARCHER ////////////////////////////////////////////////////
      HeroInterface DA = HeroFactory.createHero("DWARF", "ARCHER");
      assert DA != null: "DWARF ARCHER did not create successfully";
      
      // STR, DEX, INT
      assert DA.getSTR() == 25:"DWARF ARCHER returns incorrect STR " + DA.getSTR();
      assert DA.getDEX() == 20:"DWARF ARCHER returns incorrect DEX " + DA.getDEX();
      assert DA.getINT() == 20:"DWARF ARCHER returns incorrect INT " + DA.getINT();
      
      // attack
      // ARCHER: DEX * 1.5 * val
      //          20  * 1.5  * 10 = 300
      assert DA.attack(10) == 300: "Incorrect value produced from attack " + DA.attack(10) + ", should be 300";
      
      // Checking negative values
      //          20  * 1.5  * -1 = -30
      assert DA.attack(-1) == -30: "Incorrect value produced from attack " + DA.attack(-1) + ", should be -30";
      
      // Test race name
      assert DA.getRaceName().equals("DWARF"): "Race name not returned correctly: " + DA.getRaceName() + ", should be DWARF";
      
      // Test job name
      assert DA.getJobName().equals("ARCHER"): "Job name not returned correctly: " + DA.getJobName() + ", should be ARCHER";
      
      //////////////////////////////////////////////// Testing DWARF MAGE ///////////////////////////////////////////////////
      HeroInterface DM = HeroFactory.createHero("DWARF", "MAGE");
      assert DM != null: "DWARF MAGE did not create successfully";
      
      // STR, DEX, INT
      assert DM.getSTR() == 25:"DWARF MAGE returns incorrect STR " + DM.getSTR();
      assert DM.getDEX() == 20:"DWARF MAGE returns incorrect DEX " + DM.getDEX();
      assert DM.getINT() == 20:"DWARF MAGE returns incorrect INT " + DM.getINT();
      
      // attack
      // MAGE: DEX + INT * val
      //          20 + 20 * 10 = 220
      assert DM.attack(10) == 220: "Incorrect value produced from attack " + DM.attack(10) + ", should be 220";
      
      // Checking negative values
      //          20 + 20 * -1 = 0
      assert DM.attack(-1) == 0: "Incorrect value produced from attack " + DM.attack(-1) + ", should be 0";
      
      // Test race name
      assert DM.getRaceName().equals("DWARF"): "Race name not returned correctly: " + DM.getRaceName() + ", should be DWARF";
      
      // Test job name
      assert DM.getJobName().equals("MAGE"): "Job name not returned correctly: " + DM.getJobName() + ", should be MAGE";
      
      ////////////////////////////////////////////// Testing ELF WARRIOR ////////////////////////////////////////////////////
      HeroInterface EW = HeroFactory.createHero("ELF", "WARRIOR");
      assert EW != null: "ELF WARRIOR did not create successfully";
      
      // STR, DEX, INT
      assert EW.getSTR() == 20:"ELF WARRIOR returns incorrect STR " + EW.getSTR();
      assert EW.getDEX() == 25:"ELF WARRIOR returns incorrect DEX " + EW.getDEX();
      assert EW.getINT() == 20:"ELF WARRIOR returns incorrect INT " + EW.getINT();
      
      // attack
      // Warrior: STR * val + DEX
      //          20  * 10  + 25 = 225
      assert EW.attack(10) == 225: "Incorrect value produced from attack " + EW.attack(10) + ", should be 225";
      
      // Checking negative values
      //          20  * -1  + 25 = 5
      assert EW.attack(-1) == 5: "Incorrect value produced from attack " + EW.attack(-1) + ", should be 5";
      
      // Test race name
      assert EW.getRaceName().equals("ELF"): "Race name not returned correctly: " + EW.getRaceName() + ", should be ELF";
      
      // Test job name
      assert EW.getJobName().equals("WARRIOR"): "Job name not returned correctly: " + EW.getJobName() + ", should be WARRIOR";
      
      //////////////////////////////////////// Testing ELF ARCHER //////////////////////////////////////////////////////////
      HeroInterface EA = HeroFactory.createHero("ELF", "ARCHER");
      assert EA != null: "ELF ARCHER did not create successfully";
      
      // STR, DEX, INT
      assert EA.getSTR() == 20:"ELF ARCHER returns incorrect STR " + EA.getSTR();
      assert EA.getDEX() == 25:"ELF ARCHER returns incorrect DEX " + EA.getDEX();
      assert EA.getINT() == 20:"ELF ARCHER returns incorrect INT " + EA.getINT();
      
      // attack
      // ARCHER: DEX * 1.5 * val
      //          25  * 1.5  * 10 = 375
      assert EA.attack(10) == 375: "Incorrect value produced from attack " + EA.attack(10) + ", should be 375";
      
      // Checking negative values
      //          25  * 1.5  * -1 = -37
      assert EA.attack(-1) == -37: "Incorrect value produced from attack " + EA.attack(-1) + ", should be -37";
      
      // Test race name
      assert EA.getRaceName().equals("ELF"): "Race name not returned correctly: " + EA.getRaceName() + ", should be ELF";
      
      // Test job name
      assert EA.getJobName().equals("ARCHER"): "Job name not returned correctly: " + EA.getJobName() + ", should be ARCHER";
      
      ///////////////////////////////// Testing ELF MAGE ////////////////////////////////////////////////////////////////////
      HeroInterface EM = HeroFactory.createHero("ELF", "MAGE");
      assert EM != null: "ELF MAGE did not create successfully";
      
      // STR, DEX, INT
      assert EM.getSTR() == 20:"DWARF MAGE returns incorrect STR " + EM.getSTR();
      assert EM.getDEX() == 25:"DWARF MAGE returns incorrect DEX " + EM.getDEX();
      assert EM.getINT() == 20:"DWARF MAGE returns incorrect INT " + EM.getINT();
      
      // attack
      // MAGE: DEX + INT * val
      //          25 + 20 * 10 = 225
      assert EM.attack(10) == 225: "Incorrect value produced from attack " + EM.attack(10) + ", should be 225";
      
      // Checking negative values
      //          25 + 20 * -1 = 5
      assert EM.attack(-1) == 5: "Incorrect value produced from attack " + EM.attack(-1) + ", should be 5";
      
      // Test race name
      assert EM.getRaceName().equals("ELF"): "Race name not returned correctly: " + EM.getRaceName() + ", should be ELF";
      
      // Test job name
      assert EM.getJobName().equals("MAGE"): "Job name not returned correctly: " + EM.getJobName() + ", should be MAGE";

      ////////////////////////////////////////////// Testing ROBOT WARRIOR ////////////////////////////////////////////////////
      HeroInterface RW = HeroFactory.createHero("ROBOT", "WARRIOR");
      assert RW != null: "ROBOT WARRIOR did not create successfully";
      
      // STR, DEX, INT
      assert RW.getSTR() == 20:"ROBOT WARRIOR returns incorrect STR " + RW.getSTR();
      assert RW.getDEX() == 20:"ROBOT WARRIOR returns incorrect DEX " + RW.getDEX();
      assert RW.getINT() == 25:"ROBOT WARRIOR returns incorrect INT " + RW.getINT();
      
      // attack
      // Warrior: STR * val + DEX
      //          20  * 10  + 20 = 220
      assert RW.attack(10) == 220: "Incorrect value produced from attack " + RW.attack(10) + ", should be 220";
      
      // Checking negative values
      //          20  * -1  + 20 = 0
      assert RW.attack(-1) == 0: "Incorrect value produced from attack " + RW.attack(-1) + ", should be 0";
      
      // Test race name
      assert RW.getRaceName().equals("ROBOT"): "Race name not returned correctly: " + RW.getRaceName() + ", should be ROBOT";
      
      // Test job name
      assert RW.getJobName().equals("WARRIOR"): "Job name not returned correctly: " + RW.getJobName() + ", should be WARRIOR";
      
      //////////////////////////////////////// Testing ROBOT ARCHER //////////////////////////////////////////////////////////
      HeroInterface RA = HeroFactory.createHero("ROBOT", "ARCHER");
      assert RA != null: "ROBOT ARCHER did not create successfully";
      
      // STR, DEX, INT
      assert RA.getSTR() == 20:"ROBOT ARCHER returns incorrect STR " + RA.getSTR();
      assert RA.getDEX() == 20:"ROBOT ARCHER returns incorrect DEX " + RA.getDEX();
      assert RA.getINT() == 25:"ROBOT ARCHER returns incorrect INT " + RA.getINT();
      
      // attack
      // ARCHER: DEX * 1.5 * val
      //          20  * 1.5  * 10 = 300
      assert RA.attack(10) == 300: "Incorrect value produced from attack " + RA.attack(10) + ", should be 300";
      
      // Checking negative values
      //          20  * 1.5  * -1 = -30
      assert RA.attack(-1) == -30: "Incorrect value produced from attack " + RA.attack(-1) + ", should be -30";
      
      // Test race name
      assert RA.getRaceName().equals("ROBOT"): "Race name not returned correctly: " + RA.getRaceName() + ", should be ROBOT";
      
      // Test job name
      assert RA.getJobName().equals("ARCHER"): "Job name not returned correctly: " + RA.getJobName() + ", should be ARCHER";
      
      ///////////////////////////////// Testing ROBOT MAGE ////////////////////////////////////////////////////////////////////
      HeroInterface RM = HeroFactory.createHero("ROBOT", "MAGE");
      assert RM != null: "ROBOT MAGE did not create successfully";
      
      // STR, DEX, INT
      assert RM.getSTR() == 20:"ROBOT MAGE returns incorrect STR " + RM.getSTR();
      assert RM.getDEX() == 20:"ROBOT MAGE returns incorrect DEX " + RM.getDEX();
      assert RM.getINT() == 25:"ROBOT MAGE returns incorrect INT " + RM.getINT();
      
      // attack
      // MAGE: DEX + INT * val
      //          20 + 25 * 10 = 270
      assert RM.attack(10) == 270: "Incorrect value produced from attack " + RM.attack(10) + ", should be 270";
      
      // Checking negative values
      //          20 + 25 * -1 = -5
      assert RM.attack(-1) == -5: "Incorrect value produced from attack " + RM.attack(-1) + ", should be -5";
      
      // Test race name
      assert RM.getRaceName().equals("ROBOT"): "Race name not returned correctly: " + RM.getRaceName() + ", should be ROBOT";
      
      // Test job name
      assert RM.getJobName().equals("MAGE"): "Job name not returned correctly: " + RM.getJobName() + ", should be MAGE";
   }
}