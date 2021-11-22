package com.jarno.pictureservice.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageObject extends AbstractPersistable<Long>{

    /* Mahdollinen asetus postgresin takia: */
    /* @Lob
    @Type(type = "org.hibernate.type.BinaryType") */

    /* Tämä asetus muuten: */
    /* @Lob
    @Basic(fetch = FetchType.EAGER) */

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;
    
}
