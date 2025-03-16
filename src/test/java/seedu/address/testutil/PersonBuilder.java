package seedu.address.testutil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import lombok.Builder;
import seedu.address.model.anniversary.Anniversary;
import seedu.address.model.anniversary.Birthday;
import seedu.address.model.anniversary.WorkAnniversary;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
@Builder
public class PersonBuilder {

    public static final String DEFAULT_EMPLOYEE_ID = "00000000-0000-0000-0000-000000000001";
    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final Anniversary DEFAULT_BIRTHDAY = new Anniversary(LocalDate.of(2000, 1, 1),
            new HashSet<>(Set.of(new Birthday())), "Birthday", "Amy");
    public static final Anniversary DEFAULT_WORK_ANNIVERSARY = new Anniversary(LocalDate.of(2000, 1, 1),
            new HashSet<>(Set.of(new WorkAnniversary())), "Work Anniversary", "Amy");

    private UUID employeeId;
    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;
    private List<Anniversary> anniversaries;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        employeeId = UUID.fromString(DEFAULT_EMPLOYEE_ID);
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        List<Anniversary> anni = new ArrayList<>();
        anni.add(DEFAULT_BIRTHDAY);
        anni.add(DEFAULT_WORK_ANNIVERSARY);
        anniversaries = anni;
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        employeeId = personToCopy.getEmployeeId();
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        anniversaries = new ArrayList<>(personToCopy.getAnniversaries());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code EmployeeID} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmployeeId(String employeeId) {
        this.employeeId = UUID.fromString(employeeId);
        return this;
    }

    public Person build() {
        return new Person(employeeId, name, phone, email, address, tags, anniversaries);
    }

}
