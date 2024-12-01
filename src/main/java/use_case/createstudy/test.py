def _swap_up(self, citizen: Citizen) -> Citizen:
    """Swap <citizen> with their superior in this Society (they should
     swap their job, and their position in the tree, but otherwise keep
     all the same attribute data they currently have).

    If the superior is a DistrictLeader, the citizens being swapped should
    also switch their citizen type (i.e. the DistrictLeader becomes a
    regular Citizen and vice versa).

    Return the Citizen after it has been swapped up ONCE in the Society.

    Precondition:
    - <citizen> has a superior (i.e., it is not the head of this Society),
      and is not a DistrictLeader.

    >>> o = Society()
    >>> c1 = Citizen(1, "Starky Industries", 3024, "Manager", 50)
    >>> c2 = DistrictLeader(
    ...     2, "Hookins National Lab", 3024, "Manager", 65, "Area 52")
    >>> c3 = Citizen(3, "Starky Industries", 3024, "Labourer", 50)
    >>> c4 = Citizen(4, "S.T.A.R.R.Y Lab", 3024, "Manager", 30)
    >>> c5 = Citizen(5, "Hookins National Lab", 3024, "Labourer", 50)
    >>> c6 = Citizen(6, "S.T.A.R.R.Y Lab", 3024, "Lawyer", 30)
    >>> o.add_citizen(c1, None)
    >>> o.add_citizen(c2, 1)
    >>> o.add_citizen(c3, 1)
    >>> o.add_citizen(c4, 2)
    >>> o.add_citizen(c5, 2)
    >>> o.add_citizen(c6, 4)
    >>> swapped_c4 = o._swap_up(c4)
    >>> swapped_c2 = o.get_citizen(2)
    >>> swapped_c2.get_direct_subordinates() == [c6]
    True
    >>> isinstance(swapped_c2, DistrictLeader)
    False
    >>> swapped_c2 in swapped_c4.get_direct_subordinates()
    True
    >>> isinstance(swapped_c4, DistrictLeader)
    True
    """

superior = citizen.get_superior()

if isinstance(superior, DistrictLeader):
    new_superior = self.change_citizen_type(citizen, superior.get_district_name())
    new_citizen = self.change_citizen_type(superior)
else:
    new_superior = citizen
    new_citizen = superior

subordinates = new_superior.get_direct_subordinates()
for subordinate in subordinates:
    subordinate.set_superior(new_citizen)
    new_citizen.add_subordinate(subordinate)

new_superior.remove_subordinate(new_citizen.cid)
new_superior.add_subordinate(new_citizen)

new_citizen.set_superior(new_superior)

if self._head is citizen:
    self._head = new_superior

return new_citizen