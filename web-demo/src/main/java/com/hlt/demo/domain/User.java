package com.qiao.demo.domain;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/7/17
 * @desc: 用户信息
 *
 * id 生成规则
 * this.register("uuid2", UUIDGenerator.class);
this.register("guid", GUIDGenerator.class);
this.register("uuid", UUIDHexGenerator.class);
this.register("uuid.hex", UUIDHexGenerator.class);
this.register("assigned", Assigned.class);
this.register("identity", IdentityGenerator.class);
this.register("select", SelectGenerator.class);
this.register("sequence", SequenceStyleGenerator.class);
this.register("seqhilo", SequenceHiLoGenerator.class);
this.register("increment", IncrementGenerator.class);
this.register("foreign", ForeignGenerator.class);
this.register("sequence-identity", SequenceIdentityGenerator.class);
this.register("enhanced-sequence", SequenceStyleGenerator.class);
this.register("enhanced-table", TableGenerator.class);
 */
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id",strategy = "increment")
    private Integer id;
    private String name;
    private int  age;
    private String  nickName;

}
