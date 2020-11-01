
package com.example.demo.iot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Object" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Description1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ObjectID" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="ObjectURN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="LWM2MVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ObjectVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MultipleInstances">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Multiple"/>
 *                         &lt;enumeration value="Single"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Mandatory">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Mandatory"/>
 *                         &lt;enumeration value="Optional"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Resources">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Item" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Operations">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="R"/>
 *                                             &lt;enumeration value="W"/>
 *                                             &lt;enumeration value="RW"/>
 *                                             &lt;enumeration value="E"/>
 *                                             &lt;enumeration value=""/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="MultipleInstances">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="Multiple"/>
 *                                             &lt;enumeration value="Single"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Mandatory">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="Mandatory"/>
 *                                             &lt;enumeration value="Optional"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Type">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="String"/>
 *                                             &lt;enumeration value="Integer"/>
 *                                             &lt;enumeration value="Float"/>
 *                                             &lt;enumeration value="Boolean"/>
 *                                             &lt;enumeration value="Opaque"/>
 *                                             &lt;enumeration value="Time"/>
 *                                             &lt;enumeration value="Objlnk"/>
 *                                             &lt;enumeration value=""/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="RangeEnumeration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Units" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Description2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ObjectType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "object"
})
@XmlRootElement(name = "LWM2M")
public class LWM2M {

    @XmlElement(name = "Object", required = true)
    protected List<LWM2M.Object> object;

    /**
     * Gets the value of the object property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the object property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LWM2M.Object }
     * 
     * 
     */
    public List<LWM2M.Object> getObject() {
        if (object == null) {
            object = new ArrayList<LWM2M.Object>();
        }
        return this.object;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Description1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ObjectID" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="ObjectURN" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="LWM2MVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ObjectVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="MultipleInstances">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Multiple"/>
     *               &lt;enumeration value="Single"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Mandatory">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Mandatory"/>
     *               &lt;enumeration value="Optional"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Resources">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Item" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Operations">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="R"/>
     *                                   &lt;enumeration value="W"/>
     *                                   &lt;enumeration value="RW"/>
     *                                   &lt;enumeration value="E"/>
     *                                   &lt;enumeration value=""/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="MultipleInstances">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="Multiple"/>
     *                                   &lt;enumeration value="Single"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="Mandatory">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="Mandatory"/>
     *                                   &lt;enumeration value="Optional"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="Type">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="String"/>
     *                                   &lt;enumeration value="Integer"/>
     *                                   &lt;enumeration value="Float"/>
     *                                   &lt;enumeration value="Boolean"/>
     *                                   &lt;enumeration value="Opaque"/>
     *                                   &lt;enumeration value="Time"/>
     *                                   &lt;enumeration value="Objlnk"/>
     *                                   &lt;enumeration value=""/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="RangeEnumeration" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Units" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Description2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ObjectType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "description1",
        "objectID",
        "objectURN",
        "lwm2MVersion",
        "objectVersion",
        "multipleInstances",
        "mandatory",
        "resources",
        "description2"
    })
    public static class Object {

        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Description1", required = true)
        protected String description1;
        @XmlElement(name = "ObjectID")
        @XmlSchemaType(name = "unsignedShort")
        protected int objectID;
        @XmlElement(name = "ObjectURN", required = true)
        protected String objectURN;
        @XmlElement(name = "LWM2MVersion")
        protected String lwm2MVersion;
        @XmlElement(name = "ObjectVersion")
        protected String objectVersion;
        @XmlElement(name = "MultipleInstances", required = true)
        protected String multipleInstances;
        @XmlElement(name = "Mandatory", required = true)
        protected String mandatory;
        @XmlElement(name = "Resources", required = true)
        protected LWM2M.Object.Resources resources;
        @XmlElement(name = "Description2", required = true)
        protected String description2;
        @XmlAttribute(name = "ObjectType", required = true)
        protected String objectType;

        /**
         * 获取name属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * 设置name属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * 获取description1属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription1() {
            return description1;
        }

        /**
         * 设置description1属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription1(String value) {
            this.description1 = value;
        }

        /**
         * 获取objectID属性的值。
         * 
         */
        public int getObjectID() {
            return objectID;
        }

        /**
         * 设置objectID属性的值。
         * 
         */
        public void setObjectID(int value) {
            this.objectID = value;
        }

        /**
         * 获取objectURN属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjectURN() {
            return objectURN;
        }

        /**
         * 设置objectURN属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjectURN(String value) {
            this.objectURN = value;
        }

        /**
         * 获取lwm2MVersion属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLWM2MVersion() {
            return lwm2MVersion;
        }

        /**
         * 设置lwm2MVersion属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLWM2MVersion(String value) {
            this.lwm2MVersion = value;
        }

        /**
         * 获取objectVersion属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjectVersion() {
            return objectVersion;
        }

        /**
         * 设置objectVersion属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjectVersion(String value) {
            this.objectVersion = value;
        }

        /**
         * 获取multipleInstances属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMultipleInstances() {
            return multipleInstances;
        }

        /**
         * 设置multipleInstances属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMultipleInstances(String value) {
            this.multipleInstances = value;
        }

        /**
         * 获取mandatory属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMandatory() {
            return mandatory;
        }

        /**
         * 设置mandatory属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMandatory(String value) {
            this.mandatory = value;
        }

        /**
         * 获取resources属性的值。
         * 
         * @return
         *     possible object is
         *     {@link LWM2M.Object.Resources }
         *     
         */
        public LWM2M.Object.Resources getResources() {
            return resources;
        }

        /**
         * 设置resources属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link LWM2M.Object.Resources }
         *     
         */
        public void setResources(LWM2M.Object.Resources value) {
            this.resources = value;
        }

        /**
         * 获取description2属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription2() {
            return description2;
        }

        /**
         * 设置description2属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription2(String value) {
            this.description2 = value;
        }

        /**
         * 获取objectType属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjectType() {
            return objectType;
        }

        /**
         * 设置objectType属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjectType(String value) {
            this.objectType = value;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Item" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Operations">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="R"/>
         *                         &lt;enumeration value="W"/>
         *                         &lt;enumeration value="RW"/>
         *                         &lt;enumeration value="E"/>
         *                         &lt;enumeration value=""/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="MultipleInstances">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="Multiple"/>
         *                         &lt;enumeration value="Single"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="Mandatory">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="Mandatory"/>
         *                         &lt;enumeration value="Optional"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="Type">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="String"/>
         *                         &lt;enumeration value="Integer"/>
         *                         &lt;enumeration value="Float"/>
         *                         &lt;enumeration value="Boolean"/>
         *                         &lt;enumeration value="Opaque"/>
         *                         &lt;enumeration value="Time"/>
         *                         &lt;enumeration value="Objlnk"/>
         *                         &lt;enumeration value=""/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="RangeEnumeration" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Units" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Resources {

            @XmlElement(name = "Item", required = true)
            protected List<LWM2M.Object.Resources.Item> item;

            /**
             * Gets the value of the item property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the item property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LWM2M.Object.Resources.Item }
             * 
             * 
             */
            public List<LWM2M.Object.Resources.Item> getItem() {


                AtomicReference af = new AtomicReference();
                if (item == null) {
                    item = new ArrayList<LWM2M.Object.Resources.Item>();
                }
                return this.item;
            }


            /**
             * <p>anonymous complex type的 Java 类。
             * 
             * <p>以下模式片段指定包含在此类中的预期内容。
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Operations">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="R"/>
             *               &lt;enumeration value="W"/>
             *               &lt;enumeration value="RW"/>
             *               &lt;enumeration value="E"/>
             *               &lt;enumeration value=""/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="MultipleInstances">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="Multiple"/>
             *               &lt;enumeration value="Single"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="Mandatory">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="Mandatory"/>
             *               &lt;enumeration value="Optional"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="Type">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="String"/>
             *               &lt;enumeration value="Integer"/>
             *               &lt;enumeration value="Float"/>
             *               &lt;enumeration value="Boolean"/>
             *               &lt;enumeration value="Opaque"/>
             *               &lt;enumeration value="Time"/>
             *               &lt;enumeration value="Objlnk"/>
             *               &lt;enumeration value=""/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="RangeEnumeration" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Units" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "name",
                "operations",
                "multipleInstances",
                "mandatory",
                "type",
                "rangeEnumeration",
                "units",
                "description"
            })
            public static class Item {

                @XmlElement(name = "Name", required = true)
                protected String name;
                @XmlElement(name = "Operations", required = true)
                protected String operations;
                @XmlElement(name = "MultipleInstances", required = true)
                protected String multipleInstances;
                @XmlElement(name = "Mandatory", required = true)
                protected String mandatory;
                @XmlElement(name = "Type", required = true)
                protected String type;
                @XmlElement(name = "RangeEnumeration", required = true)
                protected String rangeEnumeration;
                @XmlElement(name = "Units", required = true)
                protected String units;
                @XmlElement(name = "Description", required = true)
                protected String description;
                @XmlAttribute(name = "ID", required = true)
                @XmlSchemaType(name = "unsignedShort")
                protected int id;

                /**
                 * 获取name属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * 设置name属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

                /**
                 * 获取operations属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOperations() {
                    return operations;
                }

                /**
                 * 设置operations属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOperations(String value) {
                    this.operations = value;
                }

                /**
                 * 获取multipleInstances属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMultipleInstances() {
                    return multipleInstances;
                }

                /**
                 * 设置multipleInstances属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMultipleInstances(String value) {
                    this.multipleInstances = value;
                }

                /**
                 * 获取mandatory属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMandatory() {
                    return mandatory;
                }

                /**
                 * 设置mandatory属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMandatory(String value) {
                    this.mandatory = value;
                }

                /**
                 * 获取type属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * 设置type属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * 获取rangeEnumeration属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRangeEnumeration() {
                    return rangeEnumeration;
                }

                /**
                 * 设置rangeEnumeration属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRangeEnumeration(String value) {
                    this.rangeEnumeration = value;
                }

                /**
                 * 获取units属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUnits() {
                    return units;
                }

                /**
                 * 设置units属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUnits(String value) {
                    this.units = value;
                }

                /**
                 * 获取description属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDescription() {
                    return description;
                }

                /**
                 * 设置description属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDescription(String value) {
                    this.description = value;
                }

                /**
                 * 获取id属性的值。
                 * 
                 */
                public int getID() {
                    return id;
                }

                /**
                 * 设置id属性的值。
                 * 
                 */
                public void setID(int value) {
                    this.id = value;
                }

            }

        }

    }

}
