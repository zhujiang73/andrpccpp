/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package tutorial;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

/**
 * Structs are the basic complex data structures. They are comprised of fields
 * which each have an integer identifier, a type, a symbolic name, and an
 * optional default value.
 * 
 * Fields can be declared "optional", which ensures they will not be included
 * in the serialized output if they aren't set.  Note that this requires some
 * manual management in some languages.
 */
public class Work implements TBase {
  private static final TStruct STRUCT_DESC = new TStruct("Work");

  private static final TField NUM1_FIELD_DESC = new TField("num1", TType.I32, (short)1);
  private static final TField NUM2_FIELD_DESC = new TField("num2", TType.I32, (short)2);
  private static final TField OP_FIELD_DESC = new TField("op", TType.I32, (short)3);
  private static final TField COMMENT_FIELD_DESC = new TField("comment", TType.STRING, (short)4);

  private int num1;
  private int num2;
  private Operation op;
  private String comment;

  // isset id assignments
  private static final int __NUM1_ISSET_ID = 0;
  private static final int __NUM2_ISSET_ID = 1;
  private boolean[] __isset_vector = new boolean[2];

  public Work() {
    this.num1 = 0;

  }

  public Work(
    int num1,
    int num2,
    Operation op)
  {
    this();
    this.num1 = num1;
    setNum1IsSet(true);
    this.num2 = num2;
    setNum2IsSet(true);
    this.op = op;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Work(Work other) {
    System.arraycopy(other.__isset_vector, 0, __isset_vector, 0, other.__isset_vector.length);
    this.num1 = other.num1;
    this.num2 = other.num2;
    if (other.isSetOp()) {
      this.op = other.op;
    }
    if (other.isSetComment()) {
      this.comment = other.comment;
    }
  }

  public Work deepCopy() {
    return new Work(this);
  }

  public void clear() {
    this.num1 = 0;

    setNum2IsSet(false);
    this.num2 = 0;
    this.op = null;
    this.comment = null;
  }

  public int getNum1() {
    return this.num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
    setNum1IsSet(true);
  }

  public void unsetNum1() {
    __isset_vector[__NUM1_ISSET_ID] = false;
  }

  /** Returns true if field num1 is set (has been assigned a value) and false otherwise */
  public boolean isSetNum1() {
    return __isset_vector[__NUM1_ISSET_ID];
  }

  public void setNum1IsSet(boolean value) {
    __isset_vector[__NUM1_ISSET_ID] = value;
  }

  public int getNum2() {
    return this.num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
    setNum2IsSet(true);
  }

  public void unsetNum2() {
    __isset_vector[__NUM2_ISSET_ID] = false;
  }

  /** Returns true if field num2 is set (has been assigned a value) and false otherwise */
  public boolean isSetNum2() {
    return __isset_vector[__NUM2_ISSET_ID];
  }

  public void setNum2IsSet(boolean value) {
    __isset_vector[__NUM2_ISSET_ID] = value;
  }

  /**
   * 
   * @see Operation
   */
  public Operation getOp() {
    return this.op;
  }

  /**
   * 
   * @see Operation
   */
  public void setOp(Operation op) {
    this.op = op;
  }

  public void unsetOp() {
    this.op = null;
  }

  /** Returns true if field op is set (has been assigned a value) and false otherwise */
  public boolean isSetOp() {
    return this.op != null;
  }

  public void setOpIsSet(boolean value) {
    if (!value) {
      this.op = null;
    }
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void unsetComment() {
    this.comment = null;
  }

  /** Returns true if field comment is set (has been assigned a value) and false otherwise */
  public boolean isSetComment() {
    return this.comment != null;
  }

  public void setCommentIsSet(boolean value) {
    if (!value) {
      this.comment = null;
    }
  }

  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Work)
      return this.equals((Work)that);
    return false;
  }

  public boolean equals(Work that) {
    if (that == null)
      return false;

    boolean this_present_num1 = true;
    boolean that_present_num1 = true;
    if (this_present_num1 || that_present_num1) {
      if (!(this_present_num1 && that_present_num1))
        return false;
      if (this.num1 != that.num1)
        return false;
    }

    boolean this_present_num2 = true;
    boolean that_present_num2 = true;
    if (this_present_num2 || that_present_num2) {
      if (!(this_present_num2 && that_present_num2))
        return false;
      if (this.num2 != that.num2)
        return false;
    }

    boolean this_present_op = true && this.isSetOp();
    boolean that_present_op = true && that.isSetOp();
    if (this_present_op || that_present_op) {
      if (!(this_present_op && that_present_op))
        return false;
      if (!this.op.equals(that.op))
        return false;
    }

    boolean this_present_comment = true && this.isSetComment();
    boolean that_present_comment = true && that.isSetComment();
    if (this_present_comment || that_present_comment) {
      if (!(this_present_comment && that_present_comment))
        return false;
      if (!this.comment.equals(that.comment))
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

    Work other = (Work)otherObject;    int lastComparison = 0;

    lastComparison = TBaseHelper.compareTo(isSetNum1(), other.isSetNum1());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNum1()) {
      lastComparison = TBaseHelper.compareTo(this.num1, other.num1);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetNum2(), other.isSetNum2());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNum2()) {
      lastComparison = TBaseHelper.compareTo(this.num2, other.num2);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetOp(), other.isSetOp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOp()) {
      lastComparison = TBaseHelper.compareTo(this.op, other.op);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetComment(), other.isSetComment());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComment()) {
      lastComparison = TBaseHelper.compareTo(this.comment, other.comment);
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
        case 1: // NUM1
          if (field.type == TType.I32) {
            this.num1 = iprot.readI32();
            setNum1IsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // NUM2
          if (field.type == TType.I32) {
            this.num2 = iprot.readI32();
            setNum2IsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // OP
          if (field.type == TType.I32) {
            this.op = Operation.findByValue(iprot.readI32());
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // COMMENT
          if (field.type == TType.STRING) {
            this.comment = iprot.readString();
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
    oprot.writeFieldBegin(NUM1_FIELD_DESC);
    oprot.writeI32(this.num1);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(NUM2_FIELD_DESC);
    oprot.writeI32(this.num2);
    oprot.writeFieldEnd();
    if (this.op != null) {
      oprot.writeFieldBegin(OP_FIELD_DESC);
      oprot.writeI32(this.op.getValue());
      oprot.writeFieldEnd();
    }
    if (this.comment != null) {
      if (isSetComment()) {
        oprot.writeFieldBegin(COMMENT_FIELD_DESC);
        oprot.writeString(this.comment);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("Work(");
    boolean first = true;

    sb.append("num1:");
    sb.append(this.num1);
    first = false;
    if (!first) sb.append(", ");
    sb.append("num2:");
    sb.append(this.num2);
    first = false;
    if (!first) sb.append(", ");
    sb.append("op:");
    if (this.op == null) {
      sb.append("null");
    } else {
      sb.append(this.op);
    }
    first = false;
    if (isSetComment()) {
      if (!first) sb.append(", ");
      sb.append("comment:");
      if (this.comment == null) {
        sb.append("null");
      } else {
        sb.append(this.comment);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

