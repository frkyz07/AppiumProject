package testng;


import devices.DeviceFarm;
import helper.fakerClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.HomePage;
import utility.DeviceFarmUtility;
///usr/libexec/java_home
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

public class ContactManagerTestNG extends fakerClass {

    public static AppiumDriver<?> Driver;
    HomePage homePage;
    AddContactPage addContactPage;
    String oreo, kitkat;
    DesiredCapabilities capabilities;
    String specialCharacters = "&%+^^";
    String bigName = firstName()+firstName()+firstName()+firstName()+firstName();
    String bigPhoneNumber = phoneNumber()+phoneNumber()+phoneNumber()+phoneNumber()+phoneNumber();
    String bigEmail = eMail()+eMail()+eMail()+eMail()+eMail();


    public ContactManagerTestNG() {
        oreo = DeviceFarm.ANDROID_OREO.path;
        kitkat = DeviceFarm.ANDROID_KITKAT.path;

    }
    @BeforeClass
    public void setup() throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
        capabilities.setCapability("app", new File("/Users/farukayaz/Applications/ContactManager.apk").getAbsolutePath());
        Driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
        homePage = new HomePage();
        addContactPage = new AddContactPage();
    }
    @Test(priority = 0)
    public void openAddContactOnOreo() throws NullPointerException, InterruptedException {

        homePage.getAddContactBtn().click();
        Thread.sleep(4000);
    }

    @Test(priority = 1)
    public void checkAddContactTitle(){
        //User checks title whether it is "Add Contact"
        Assert.assertEquals(addContactPage.getTitle().getText(),"Add Contact");
    }
    @Test
    public void targetAccountCheck(){
        try {
            //User check the account whether it is correct
            homePage.getAddContactBtn().click();
            Assert.assertEquals(addContactPage.getTargetAccountText().getText(), myMail);
        }catch(Exception e){
            System.out.println("Couldnt find the locator");
        }
    }
    @Test
    public void userAddsHomePhoneHomeMailContact(){

            //User adds a work account successfully
        try {
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e){
            System.out.println("Couldnt find the element in the home page"+e);
        }
        try {
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropHome().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropHome().click();
        }catch(NoSuchElementException e){
            System.out.println("Couldn't find the element in the add contact page"+e);
        }
        try{
            Assert.assertTrue();
        }catch(AssertionError e){
            System.out.println("Your expected value did not match with the actual value"+e);
        }

    }
    @Test
    public void userAddsHomePhoneWorkMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropHome().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropWork().click();
        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page"+e.getMessage());
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsHomePhoneHomeMobileContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();

        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropHome().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropMobile().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }

    @Test
    public void userAddsHomePhoneHomeOtherContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropHome().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsWorkPhoneHomeMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropWork().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropHome().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsWorkPhoneWorkMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropWork().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropWork().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }

    }
    @Test
    public void userAddsWorkPhoneMobileMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropWork().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropMobile().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsWorkPhoneWorkOtherContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropWork().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsMobilePhoneHomeMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropMobile().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropHome().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsMobilePhoneWorkMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropMobile().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropWork().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsMobilePhoneMobileMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropMobile().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropMobile().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsMobilePhoneOtherMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropWork().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsOtherPhoneHomeMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropHome().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsOtherPhoneWorkMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropWork().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page ");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsOtherPhoneMobileMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropMobile().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add contact page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void userAddsOtherPhoneOtherMailContact(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();

        }catch (Exception e){
            System.out.println("Couldn't find the locator in the add account page");
        }
        try{

        }catch(){

        }
    }
    @Test
    public void requiredAreasEmptyContactName(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue("");
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("You should enter a name "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void requiredAreasEmptyPhone(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue("");
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("You should enter a phone "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void requiredAreasEmptyEmail(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue("");
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("You should enter a mail "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void nameWithSpecialCharacters(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(specialCharacters+firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("You should enter a valid name "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void emailWithSpecialCharacters(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(specialCharacters+eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("You should enter a valid name "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void phoneWithSpecialCharacters(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(specialCharacters+phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("You should enter a valid phone number "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void rangeTestingOfNameField(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(bigName);
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("The name is out of range "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void rangeTestingOfPhoneField(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(bigPhoneNumber);
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("The phone number is out of range "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void rangeTestingOfPhoneField(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(firstName());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(bigEmail);
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("The email is out of range "+e);
        }
        try{

        }catch(){

        }

    }
    @Test
    public void nameFieldWithNumber(){
        try {
            //User adds a work account successfully
            homePage.getAddContactBtn().click();
        }catch(NoSuchElementException e) {
            System.out.println("Couldn't find the element in the home page" + e);
        }
        try{
            addContactPage.getContactNameField().setValue(phoneNumber());
            addContactPage.getContactPhoneField().setValue(phoneNumber());
            addContactPage.getContactPhoneDrop().click();
            addContactPage.getContactTypeDropOther().click();
            addContactPage.getContactEmailField().setValue(eMail());
            addContactPage.getContactEmailDrop().click();
            addContactPage.getContactTypeDropOther().click();
        }catch(Exception e ){
            System.out.println("Cant use number in the name field"+e);
        }
        try{

        }catch(){

        }

    }


    @AfterClass
    public void waiter() throws InterruptedException {
        Thread.sleep(5000);
    }

}
