/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package shared;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class SharedStruct implements TBase {
  private static final TStruct STRUCT_DESC = new TStruct("SharedStruct");

  private static final TField KEY_FIELD_DESC = new TField("key", TType.I32, (short)1);
  private static final TField VALUE_FIELD_DESC = new TField("value", TType.STRING, (short)2);

  private int key;
  private String value;

  // isset id assignments
  private static final int __KEY_ISSET_ID = 0;
  private boolean[] __isset_vector = new boolean[1];

  public SharedStruct() {
  }

  public SharedStruct(
    int key,
    String value)
  {
    this();
    this.key = key;
    setKeyIsSet(true);
    this.value = value;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SharedStruct(SharedStruct other) {
    System.arraycopy(other.__isset_vector, 0, __isset_vector, 0, other.__isset_vector.length);
    this.key = other.key;
    if (other.isSetValue()) {
      this.value = other.value;
    }
  }

  public SharedStruct deepCopy() {
    return new SharedStruct(this);
  }

  public void clear() {
    setKeyIsSet(false);
    this.key = 0;
    this.value = null;
  }

  public int getKey() {
    return this.key;
  }

  public void setKey(int key) {
    this.key = key;
    setKeyIsSet(true);
  }

  public void unsetKey() {
    __isset_vector[__KEY_ISSET_ID] = false;
  }

  /** Returns true if field key is set (has been assigned a value) and false otherwise */
  public boolean isSetKey() {
    return __isset_vector[__KEY_ISSET_ID];
  }

  public void setKeyIsSet(boolean value) {
    __isset_vector[__KEY_ISSET_ID] = value;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void unsetValue() {
    this.value = null;
  }

  /** Returns true if field value is set (has been assigned a value) and false otherwise */
  public boolean isSetValue() {
    return this.value != null;
  }

  public void setValueIsSet(boolean value) {
    if (!value) {
      this.value = null;
    }
  }

  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SharedStruct)
      return this.equals((SharedStruct)that);
    return false;
  }

  public boolean equals(SharedStruct that) {
    if (that == null)
      return false;

    boolean this_present_key = true;
    boolean that_present_key = true;
    if (this_present_key || that_present_key) {
      if (!(this_present_key && that_present_key))
        return false;
      if (this.key != that.key)
        return false;
    }

    boolean this_present_value = true && this.isSetValue();
    boolean that_present_value = true && that.isSetValue();
    if (this_present_value || that_present_value) {
      if (!(this_present_value && that_present_value))
        return false;
      if (!this.value.equals(that.value))
        return false;
    }

    return true;
  }

  public int hashCode() {
    return 0;
  }

  public int compareTo(Object otherObject) {
    if (!getClass().equals(otherObject.getClass())) {
      return getClass().getName().compareTo(otherObject.getClass().getName());
    }

    SharedStruct other = (SharedStruct)otherObject;    int lastComparison = 0;

    lastComparison = TBaseHelper.compareTo(isSetKey(), other.isSetKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKey()) {
      lastComparison = TBaseHelper.compareTo(this.key, other.key);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetValue(), other.isSetValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue()) {
      lastComparison = TBaseHelper.compareTo(this.value, other.value);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // KEY
          if (field.type == TType.I32) {
            this.key = iprot.readI32();
            setKeyIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // VALUE
          if (field.type == TType.STRING) {
            this.value = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(KEY_FIELD_DESC);
    oprot.writeI32(this.key);
    oprot.writeFieldEnd();
    if (this.value != null) {
      oprot.writeFieldBegin(VALUE_FIELD_DESC);
      oprot.writeString(this.value);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("SharedStruct(");
    boolean first = true;

    sb.append("key:");
    sb.append(this.key);
    first = false;
    if (!first) sb.append(", ");
    sb.append("value:");
    if (this.value == null) {
      sb.append("null");
    } else {
      sb.append(this.value);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

